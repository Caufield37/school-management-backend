package com.school.Student;
import com.school.Database.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    public boolean insertStudent(Student student) {
        String query = "INSERT INTO students ( first_name, last_name, gpa, age, grade, classroom_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, student.getFirstName());
            pstm.setString(2, student.getLastName());
            pstm.setDouble(3, student.getGpa());
            pstm.setInt(4, student.getAge());
            pstm.setString(5, student.getGrade());
            pstm.setInt(6, student.getClassroomId());

            int rowsAffectd = pstm.executeUpdate();
            return rowsAffectd > 0;

        } catch (SQLException e) {
            System.out.println("Database insert error" + e.getMessage());
            return false;
        }
    }


    public Student getStudentById(int studentId) {
        String query = "SELECT * FROM students WHERE student_id = ?";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstm = conn.prepareStatement(query)){

            pstm.setInt(1, studentId);

            try(ResultSet rs = pstm.executeQuery()) {
                if(rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    double gpa = rs.getDouble("gpa");
                    int age = rs.getInt("age");
                    String grade = rs.getString("grade");
                    Integer classroomId = rs.getInt("classroom_id");

                    return new Student(firstName, lastName, gpa, age, grade, classroomId);
                }

                return null;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public List<Student> getAllStudents() {

        String query = "SELECT * FROM students";

        List<Student> studentList = new ArrayList<>();

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstm = conn.prepareStatement(query)) {

            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {

                int studentId = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                double gpa = rs.getDouble("gpa");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                Integer classroomId = rs.getInt("classroom_id");

                studentList.add(new Student(firstName, lastName, gpa, age, grade, classroomId));
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentList;

    }

    public void updateStudentById(Student student, int studentId) {

        String query = "UPDATE students SET first_name = ?, last_name = ?, gpa = ?, age = ?, grade = ? WHERE student_id = ?";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, student.getFirstName());
            pstm.setString(2, student.getLastName());
            pstm.setDouble(3, student.getGpa());
            pstm.setInt(4, student.getAge());
            pstm.setString(5, student.getGrade());
            pstm.setInt(6, studentId);

            pstm.executeUpdate();
            System.out.println("Done updating successfully...");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public void deleteStudentById(int studentId) {
        String query = "DELETE FROM students WHERE student_id = ?";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setInt(1, studentId);
            pstm.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

