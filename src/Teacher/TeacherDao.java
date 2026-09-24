package Teacher;
import Database.DatabaseConfig;
import Student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TeacherDao {

    //inserting new teacher to the database table
    public void insertTeacher(Teacher teacher) {

        //even though in teacher object, it has first_name and last_name,
        //here i want to combine name by concaneting two strings
        String name = teacher.getFirstName() + " " +  teacher.getLastName();

        //insert into teachers tabes,
        //the values are name, age and subject
        String query = "INSERT into teachers(name, age, subject) VALUES (?, ?, ?)";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstm = conn.prepareStatement(query)) {

            //In the query the first one is name, so here it is
            pstm.setString(1, name);

            //the second one is age, so here it is
            pstm.setInt(2, teacher.getAge());

            //the third one is subject, and here we go
            pstm.setString(3, teacher.getSubject());


            //then execute the statement using executeUpdating.
            pstm.executeUpdate();

            System.out.println("Teachers have been added successfully....");


        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Teacher getTeacherById(int teacher_id) {

        //the query is selecting the specific teacher from teachers table where it matches with it
        String query = "SELECT * FROM teachers where id=?";

        try(Connection conn = DatabaseConfig.getConnection();
        PreparedStatement pstm = conn.prepareStatement(query)) {

            //assign teacher_id into pstm.
            pstm.setInt(1, teacher_id);

            //executeQuery return a ResultSet cursor pointing to the rows returned by the query
            try(ResultSet rs = pstm.executeQuery()) {

                //check if a row exist matching to teacher id and move the cursor to it
                if(rs.next()) {
                    //the first column is name so assigned it to full_name variable
                    String full_name = rs.getString("name");

                    //the second column is age so store in age
                    int age = rs.getInt("age");

                    //then store subject column in subject variable
                    String subject = rs.getString("subject");

                    //check if the full name is not null and full name is not empty
                    if(full_name != null && !full_name.trim().isEmpty()) {
                        //full name needed to be split into two parts, first name and second name
                        //so split them and store in parts list
                        String[] parts = full_name.split(" ", 2);

                        //the first element in the parts is first name, so store it
                        String first_name = parts[0];


                        String last_name;
                        //only if that part array is longer than 1 mean that the user has the last name
                        //so check using if
                        if(parts.length > 1) {
                            //if longer than one, store the second part as last_name
                            last_name = parts[1];
                        } else {
                            //if not, last_name would be blank
                            last_name = " ";
                        }
                        //return teacher as a whole object
                        return new Teacher(first_name, last_name, age, subject);
                    }


                }
                return null;
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //this method retrieve all the teacher from the database
    public List<Teacher> getAllTeachers() {

        //create teacherList to store all the teacher in the list
        List<Teacher> teacherList = new ArrayList<>();

        //select all the elements in teachers table
        String query = "SELECT * FROM teachers";

        try(Connection conn = DatabaseConfig.getConnection();
        PreparedStatement pstm = conn.prepareStatement(query)) {

            //store the row return by query in resultset object rs
            ResultSet rs = pstm.executeQuery();

            //as far as rs has another element, the looping continue
            while(rs.next()) {

                //store id column in id variable
                int id = rs.getInt("id");

                //store name column in full name variable
                String full_name = rs.getString("name");

                //store age
                int age = rs.getInt("age");

                //store subject
                String subject = rs.getString("subject");

                String first_name;
                String last_name;

                //if full_name is not null AND empty, assign to first_name and last_name each
                if(full_name != null && !full_name.trim().isEmpty()) {
                    String[] parts = full_name.split(" ", 2);

                    first_name = parts[0];

                    if(parts.length > 1) {
                        last_name = parts[1];
                    } else {
                        last_name = "";
                    }
                }
                //if not both will be blanks
                else {
                    first_name = "";
                    last_name = "";
                }

                //then store then in a list by creating a teacher object
                teacherList.add(new Teacher(first_name, last_name, age, subject));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return teacherList;
    }


    public void updateTeacherById(Teacher teacher, int teacherId) {

        String query = "UPDATE teachers SET name = ?, age = ?, subject = ? WHERE id = ?";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, teacher.getFirstName() + " " + teacher.getLastName());
            pstm.setInt(2, teacher.getAge());
            pstm.setString(3, teacher.getSubject());
            pstm.setInt(4, teacherId);

            pstm.executeUpdate();
            System.out.println("Done updating successfully...");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTeacherById(int teacherId) {
        String query = "DELETE FROM teachers WHERE id = ?";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setInt(1, teacherId);
            pstm.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
