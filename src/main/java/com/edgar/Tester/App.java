package com.edgar.Tester;

import java.util.Date;
import java.util.List;

import com.edgar.model.DoorVO;
import com.edgar.model.ProfileVO;
import com.edgar.model.SystemVO;
import com.edgar.model.UserVO;
import com.edgar.services.SystemServices;
import com.edgar.services.UserServices;

/**
 * Hello world!
 *
 */
public class App 
{
	SystemServices systemServices = new SystemServices();
	UserServices userServices = new UserServices();
	
	public App() {
		
		pruebaUsuarios();		
		
	}
	
	public void pruebaUsuarios() {
		
		SystemVO system1 = new SystemVO();
		system1.setName("Sistema XXX");		
		
		system1 = systemServices.saveSystem(system1);
		
		DoorVO door1 = new DoorVO();
		door1.setCode(100);
		door1.setDescription("Door 100");
		door1.setSystem(system1);

		DoorVO door2 = new DoorVO();
		door2.setCode(200);
		door2.setDescription("Door 200");
		door2.setSystem(system1);
		
		systemServices.saveDoor(door1);
		systemServices.saveDoor(door2);
		
		UserVO user1 = new UserVO();
		user1.setNombres("nombre user 1");
		user1.setApellidos("apellidos");
		user1.setCreationDate(new Date());
		
		UserVO user2 = new UserVO();
		user2.setNombres("nombre user 2");
		user2.setApellidos("ape");
		user2.setCreationDate(new Date());		
		
		ProfileVO profile1 = new ProfileVO();
		profile1.setName("Perfil 1");
		profile1.setSystem(system1);
		
		profile1.getAccesos().add(door1);
		profile1.getAccesos().add(door2);
		
		ProfileVO profile2 = new ProfileVO();
		profile2.setName("Perfil 2");
		profile2.setSystem(system1);
		
		ProfileVO profile3 = new ProfileVO();
		profile3.setName("Perfil 3");
		profile3.setSystem(system1);
		
		profile1 = userServices.saveProfile(profile1);
		profile2 = userServices.saveProfile(profile2);
		profile3 = userServices.saveProfile(profile3);
		
		user1.getProfiles().add(profile1);
		user1.getProfiles().add(profile2);
		user1.getProfiles().add(profile3);

		user2.getProfiles().add(profile1);
		user2.getProfiles().add(profile2);
		user2.getProfiles().add(profile3);		
		
		userServices.saveUser(user1);
		userServices.saveUser(user2);
		
	}
	
	public void pruebaSistemas() {
		
		SystemVO system1 = new SystemVO();
		system1.setName("Sistema XXX");
		
		DoorVO door1 = new DoorVO();
		door1.setCode(100);
		door1.setDescription("Door 100");
		
		DoorVO door2 = new DoorVO();
		door2.setCode(200);
		door2.setDescription("Door 200");	
		
		//system1.getDoors().add(door1);
		//system1.getDoors().add(door2);
		
		SystemVO system2 = new SystemVO();
		system2.setName("Sistema YYY");

		DoorVO door3 = new DoorVO();
		door3.setCode(300);
		door3.setDescription("Door 300");
		
		//system2.getDoors().add(door3);		
		
		system1 = systemServices.saveSystem(system1);
		system2 = systemServices.saveSystem(system2);
		
		door1.setSystem(system1);
		door2.setSystem(system1);
		door3.setSystem(system1);
		
		systemServices.saveDoor(door1);
		systemServices.saveDoor(door2);
		systemServices.saveDoor(door3);
		
		List<SystemVO> lista = null;
		
		/*List<SystemVO> lista = systemServices.getAllSystems();
		for (int i=0;i<lista.size();i++) {
			
			if (i == 0) {
				
				lista.get(i).getDoors().add(door1);
				lista.get(i).getDoors().add(door2);
				
				systemServices.addSystem(lista.get(i));

				systemServices.addDoor(lista.get(i).getIdSystem(), door1);
				systemServices.addDoor(lista.get(i).getIdSystem(), door2);				
			}
			
		}*/
		
		lista = systemServices.getAllSystems();
		for (int i=0;i<lista.size();i++) {
			System.out.println("Sistema: " + lista.get(i).getIdSystem() + " - " + lista.get(i).getName());
					
			/*List<DoorVO> listaDoors = systemServices.getDoorsBySystem(lista.get(i).getIdSystem());
			for (int d=0;d<listaDoors.size();d++) {
				System.out.println("Puerta: " + listaDoors.get(i).getDescription());
			}*/
		}			
		
	}
	
    public static void main( String[] args )
    {
        new App();
    }
}
