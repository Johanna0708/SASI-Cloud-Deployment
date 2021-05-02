package de.thbrandenburg.webapp;
	import com.fasterxml.jackson.core.JsonProcessingException;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.boot.Metadata;
	import org.hibernate.boot.MetadataSources;
	import org.hibernate.boot.registry.StandardServiceRegistry;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

	import java.util.ArrayList;


@SpringBootApplication
@RestController
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}
	ArrayList<Student> students = new ArrayList<>();


	@PostMapping("/students")
	public String createPerson(@RequestParam(value = "firstName") String firstName) {
		Student student = new Student (firstName);
		student.setAge(25);

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();

		session.beginTransaction();
		session.persist(student);
		session.flush();
		session.close();
		factory.close();
		return "Studierende(r) wurde erfolgreich in der Datenbank persistiert!";
	}


	@GetMapping("/students")
	public String viewStudents() {

		Student student2 = new Student("Anna","Schmidt");
		Student student1 = new Student("Peter","Schmidt");
		student2.setAge(19);
		students.add(student1);
				students.add(student2);

		String studentObjectMappedToJSONString = null;
			ObjectMapper om = new ObjectMapper();
			try {
				studentObjectMappedToJSONString = om.writeValueAsString(students);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return studentObjectMappedToJSONString;
	}




	@GetMapping("/greet")
	public String greet(@RequestParam(value = "name", defaultValue = "Stranger") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/join")
	public String join(@RequestBody Student student) {
		Student student3 = new Student (student.getFirstName(), student.getLastName());

		if (student3.getFirstName() == null || student3.getLastName() == null) {
			return String.format("400 - fehlerhafte Anfrage!");
		} else {
			return String.format(student.getFirstName() + " " + student.getLastName() + " wurde hinzugefügt!" + "\n" + "201 - Ressource wurde erfolgreich erstellt!");
		}
	}

}
