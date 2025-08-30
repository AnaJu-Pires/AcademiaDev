package Service;

import Controller.dto.AdminDto;
import Model.User.Admin;
import Repository.impl.AdminRepositoryImpl;

public class AdminService {

    private final AdminRepositoryImpl adminRepositoryImpl;

    public AdminService(AdminRepositoryImpl adminRepositoryImpl) {
        this.adminRepositoryImpl = adminRepositoryImpl;
    }

    public void addAdmin(AdminDto adminDto) {
        Admin admin = new Admin(adminDto.getName(), adminDto.getEmail());
        adminRepositoryImpl.addAdmin(admin);
    }
    
}
