package com.example.arafatproject.SchoolManagement.Domain;

public interface View {
    interface All {

    }

    interface ExamDetails extends All {

    }

    interface InvoiceDetails extends All {

    }

    interface UserDetails extends InvoiceDetails, ExamDetails {

    }

    interface StudentDetails extends UserDetails {

    }

    interface EmployeeDetails extends UserDetails {

    }
}
