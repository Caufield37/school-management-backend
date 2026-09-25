package com.school.Classroom;

import com.school.Database.DatabaseConfig;
import com.school.Student.StudentAcademicProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClassroomDao {

    public StudentAcademicProfile getStudentDetails(int studentId) {

        //first of all, the query select first name and last name from the students.
        //secondly, select class name from classrooms and teacher name from teachers
        //then join two tables, students and classrooms, students and teachers
        //while joining students and teachers, students is on the left and join only
        //with the classroom which has the exact class id has student's class id.
        //then join teachers using the classroom's teacher id we got previously and match with the teacher id.
        String query = """
           SELECT
                students.first_name,
                students.last_name,
                classrooms.class_name,
                teachers.name AS teacher_name
           From students
           LEFT JOIN classrooms ON students.classroom_id = classrooms.classroom_id
           LEFT JOIN teachers ON classrooms.teacher_id = teachers.id
           WHERE students.student_id = ?
            """;


    try(Connection conn = DatabaseConfig.getConnection();
        PreparedStatement pstm = conn.prepareStatement(query)) {

        //we have only one question mark, so studentId is assigned to it.
        pstm.setInt(1, studentId);

        // executeQuery() returns a ResultSet cursor pointing to the rows returned by the query.
        try(ResultSet rs = pstm.executeQuery()) {
            // Check if a row exists matching the student ID and move the cursor to it.
            if(rs.next()) {
                //the value under first_name column is stored in first_name variable
                String firstName = rs.getString("first_name");

                //the value under last_name column is stored in last_name variable
                String lastName = rs.getString("last_name");

                //the value under class_name column is stored in class_name variable
                String className = rs.getString("class_name");

                //the value under teacher_name column is stored in teacher_name variable
                String teacherName = rs.getString("teacher_name");

                //return all the value assigning to new object, studentAcademicProfile
                return new StudentAcademicProfile(firstName, lastName, className, teacherName);
            }

        }

    } catch(SQLException e) {
        System.out.println(e.getMessage());
    }

    return null;
    }


    public boolean transferStudent(int studentId, int newClassroomId) {

        //update the student's classroom id using student's id
        String query = "UPDATE students SET classroom_id = ? WHERE student_id = ?";

        try(Connection conn = DatabaseConfig.getConnection();
        PreparedStatement pstm = conn.prepareStatement(query)) {

            //in query the first question mark is for classroom_id, so newClassroomId is assigned to 1
            pstm.setInt(1, newClassroomId);

            //second question mark is for student_id, so studentId is assigned to 2
            pstm.setInt(2, studentId);

            //store the number of row affected by executeUpdate method in variable
            int rowsAffected = pstm.executeUpdate();

            //check if the rows is one or not, one is more than zero, so it would return true, else false
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void transferTeacher(int teacherId, int newClassroomId) {

        //updating the teacher id by getting the exact classroom_id that the user want to change
        String query = "UPDATE classrooms SET teacher_id = ? WHERE classroom_id = ?";

        try(Connection conn = DatabaseConfig.getConnection();
        PreparedStatement pstm = conn.prepareStatement(query)) {

            //1 is assigned to teacherId
            pstm.setInt(1, teacherId);

            //2 is assigned to newClassroomId
            pstm.setInt(2, newClassroomId);

            //execute the update
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Classroom> getAllClassroom() {

        String query = "SELECT * FROM classrooms";

        List<Classroom> classroomList = new ArrayList<>();

        try(Connection conn = DatabaseConfig.getConnection();
        PreparedStatement pstm = conn.prepareStatement(query)){

            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {

                int classroomId = rs.getInt("classroom_id");
                String className = rs.getString("class_name");
                int teacherId = rs.getInt("class_id");

                classroomList.add(new Classroom(classroomId, className, teacherId));
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return classroomList;
    }


}
