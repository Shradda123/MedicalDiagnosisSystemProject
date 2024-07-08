package com.cms.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cms.entity.Instructor;
import com.cms.entity.User;
import com.cms.model.InstructorDTO;
import com.cms.repository.InstructorRepository;
import com.cms.util.Converter;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InstructorServiceTest {

	@Autowired
	private InstructorService instructorService;
	
	@MockBean
	private InstructorRepository instructorRepository;
	
	@Autowired
	Converter converter;
	
	@Test
	@Order(1)
	void testCreateInstructor()
	{
		Instructor ins=Instructor.builder().firstName("anurag").lastName("prasad").
				email("anurag@gmail.com").userId(1).build();
		Mockito.when(instructorRepository.save(ins)).thenReturn(ins);
		assertThat(instructorService.createInstructor(ins)).isEqualTo("instructor saved successfully");
	}
	
	@Test
	@Order(3)
	void testGetAllInstructor()
	{
		
		Instructor inst=Instructor.builder().firstName("ram").lastName("sharma").
				email("ram@gmail.com").build();
		

		Instructor inst2=Instructor.builder().firstName("rajiv").lastName("dutta").
				email("rajiv@gmail.com").build();
		
		List<Instructor> list=new ArrayList<>();
		list.add(inst);
		list.add(inst2);
		
		Mockito.when(instructorRepository.findAll()).thenReturn(list);
		
	List<InstructorDTO> dto=instructorService.getAllInstructors();
	List<Instructor> instructor=new ArrayList<>();
	
	for(InstructorDTO insDto: dto)
	 {
		instructor.add(converter.covertToInstructorEntity(insDto));
	 }
		assertThat(instructor).isEqualTo(list);
	}
	
	@Test
	@DisplayName("postive test case")
	@Order(4)
	void testDeleteInstructor()
	{

		Instructor inst=Instructor.builder().firstName("ram").lastName("sharma").
				email("ram@gmail.com").userId(1).build();
		
	     Optional<Instructor> opIns=Optional.of(inst);
		
		Mockito.when(instructorRepository.existsById(opIns.get().getUserId())).
		thenReturn(false);//existsById(1)
		assertThat(instructorRepository.existsById(opIns.get().getUserId()));//existsById(1)
		
		
	}
	
	@Test
	@Order(6)
	void testGetInsById()
	{

		
		Instructor inst=Instructor.builder().firstName("ram").lastName("sharma").
				email("ram@gmail.com").userId(1).build();
		
	     Optional<Instructor> opIns=Optional.of(inst);
	     Mockito.when(instructorRepository.findById(inst.getUserId())).
			thenReturn(opIns);
	     
	     InstructorDTO dto=converter.convertToInstructorDTO(inst);
	     assertThat(instructorService.getInstructorById(inst.getUserId())).isEqualTo(dto);
	     
	}
	
	@Test
	@DisplayName("negative test case")
	@Order(5)
	void testDeleteInstructornegative()
	{
		
		Instructor inst=Instructor.builder().firstName("ram").lastName("sharma").
				email("ram@gmail.com").userId(1).build();
		
	     Optional<Instructor> opIns=Optional.of(inst);
		
		
		Mockito.when(instructorRepository.existsById(inst.getUserId())).thenReturn(false);
		assertThat(instructorService.deleteInstructor(inst.getUserId())).
		isEqualTo("Record deleted successfully");
	}
	
	@Test
	@Order(2)
	public void testUpdateInstructor()
	{
		
		Instructor inst2=Instructor.builder().firstName("ram").lastName("sharma").
				email("ram@gmail.com").userId(1).build();
			
		Optional<Instructor> ops=Optional.of(inst2);
		Instructor ins=ops.get();
		
		Mockito.when(instructorRepository.findById(1)).thenReturn(ops);
		ins.setFirstName("ram gopal");
		
		Mockito.when(instructorRepository.save(ins)).thenReturn(ins);
		InstructorDTO dto=converter.convertToInstructorDTO(ins);
		
		assertThat(instructorService.updateInstructor(1, ins)).isEqualTo(dto);
	}
	
	
}
