package it.fm3.alcolist.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fm3.alcolist.entity.Role;
import it.fm3.alcolist.entity.UserAccount;
import it.fm3.alcolist.repository.OrdinationRepository;
import it.fm3.alcolist.repository.UserAccountRepository;

@Service
@Transactional
public class StatisticsService implements StatisticsServiceI{
	@Autowired
	private UserAccountRepository userAccountRepository;
	//@Autowired
	//private CocktailRepository cocktailRepository;
	@Autowired
	private OrdinationRepository ordinationRepository;
	
	@Override
	public Integer getByNumbersOfUsers(String role) {
		
		List<UserAccount> usersList = userAccountRepository.findAll();
		List<UserAccount> usersFilteredRoleList = new ArrayList<>();;
		
		for(UserAccount u : usersList) {
			List<Role> uRoles = u.getRoles();
			int numbersRoles = uRoles.size();
			if(role.equalsIgnoreCase("WAITER")) {
				for(Role r : uRoles) {
					if(r.getName().equalsIgnoreCase(role) && numbersRoles == 1) {
						usersFilteredRoleList.add(u);
					}
				}
			}else if(role.equalsIgnoreCase("BARTENDER")) {
				boolean bart = false;
				boolean man = false;
				for(Role r : uRoles) {
					if(r.getName().equalsIgnoreCase(role)){
						bart = true;
					}
					if(r.getName().equalsIgnoreCase("MANAGER")){
						man = true;
					}
				}
				if(bart && !man) {
					usersFilteredRoleList.add(u);
				}
			}
			else if(role.equalsIgnoreCase("MANAGER")) {
				for(Role r : uRoles) {
					if(r.getName().equalsIgnoreCase(role)) {
						usersFilteredRoleList.add(u);
					}
				}
			}	
		}
		return usersFilteredRoleList.size();
	}
	
	@Override
	public Integer getNumbersOfCreatedByUser(String UserUuid) throws Exception {
		return ordinationRepository.countByCreatedBy(UserUuid);
	}

	@Override
	public Integer getNumbersOfDeliveredByUser(String UserUuid) throws Exception {
		return ordinationRepository.countByDeliveredBy(UserUuid);
	}

	@Override
	public Integer getNumbersOfExecutedByUser(String UserUuid) throws Exception {
		return ordinationRepository.countByExecutedBy(UserUuid);
	}

}
