package org.StudentPortail;

import java.util.List;
import org.StudentPortail.Student;

public interface StudentCRUD {
    void ajouterStudent(Student student);
    Student getOneStudent(String id);
    List<Student> getAllStudents();
    void updateStudent(Student student);  // Ajout de la méthode pour mettre à jour un étudiant
    void supprierStudent(String id);
}
