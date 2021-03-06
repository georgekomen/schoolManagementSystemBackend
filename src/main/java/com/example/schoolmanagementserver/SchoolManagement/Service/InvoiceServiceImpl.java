package com.example.schoolmanagementserver.SchoolManagement.Service;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.ClassInvoice;
import com.example.schoolmanagementserver.SchoolManagement.Domain.User;
import com.example.schoolmanagementserver.SchoolManagement.Domain.UserInvoice;
import com.example.schoolmanagementserver.SchoolManagement.Domain.UserReceipt;
import com.example.schoolmanagementserver.SchoolManagement.Repository.ClassInvoiceRepository;
import com.example.schoolmanagementserver.SchoolManagement.Repository.UserInvoiceRepository;
import com.example.schoolmanagementserver.SchoolManagement.Repository.StudentPaymentRepository;
import com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces.InvoiceService;
import com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private UserInvoiceRepository userInvoiceRepository;

    @Autowired
    private StudentPaymentRepository studentRepository;

    @Autowired
    private ClassInvoiceRepository classInvoiceRepository;

    @Autowired
    private UserService userService;

    @Override
    public UserInvoice newUserInvoice(UserInvoice userInvoice) {
        UserInvoice userInvoice1 = new UserInvoice(userInvoice.getInvoice_amount(),
                UserInvoice.InvoiceTo.SCHOOL_TO_USER, userInvoice.getUser(), userInvoice.getClassInvoice(), userInvoice.getName());

        return userInvoiceRepository.save(userInvoice1);
    }

    @Override
    public List<UserInvoice> getAllInvoices(Pageable pageable) {
        return userInvoiceRepository.findAll(pageable).getContent();
    }

    @Override
    public UserReceipt newPayment(UserReceipt userReceipt) {
        UserReceipt userReceipt1 = new UserReceipt(userReceipt.getPayment_mode(),
                userReceipt.getPayment_date(), userReceipt.getAmount(), userReceipt.getPayTo(),
                userReceipt.getUserInvoice());

        return studentRepository.save(userReceipt1);
    }

    @Override
    public List<UserReceipt> getAllStudentPayments(Pageable pageable) {
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public ClassInvoice newClassInvoice(ClassInvoice classInvoice) {
        ClassInvoice classInvoice1 = new ClassInvoice(classInvoice.getName(), classInvoice.getClass1(),
                classInvoice.getInvoice_amount());

        ClassInvoice classInvoice2 = classInvoiceRepository.save(classInvoice1);

        // loop through all users in this class and invoice them this
        List<User> userList = userService.getUsers(new PageRequest(1000000, 1000000), classInvoice2.getClass1());

        userList.forEach(user -> {
            UserInvoice userInvoice = new UserInvoice(
                    classInvoice2.getInvoice_amount(),
                    UserInvoice.InvoiceTo.SCHOOL_TO_USER,
                    user,
                    classInvoice2,
                    classInvoice2.getName());

            newUserInvoice(userInvoice);
        });

        return classInvoice2;
    }
}
