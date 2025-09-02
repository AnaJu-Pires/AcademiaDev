package Controller;

import Controller.dto.AdminDto;
import Service.AdminService;

public class AdminController {

    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public void addAdmin(AdminDto adminDto) {
        adminService.addAdmin(adminDto);
    }

    public AdminDto loginAdmin(String email) {
        return adminService.loginAdmin(email);
    }

    

    


    
}
