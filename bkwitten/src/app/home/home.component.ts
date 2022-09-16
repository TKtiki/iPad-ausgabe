import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {DataServiceService} from '../services/data-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  studentDetails = null as any;
  studentToUpdate = {
    id: "",
    vorname: "",
    name: "",
    klasse: "",
  };

  constructor(private schülerservice: DataServiceService) {
    this.getStudentsDetails();
  }

  register(registerForm: NgForm) {
    this.schülerservice.registerStudent(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        this.getStudentsDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getStudentsDetails() {
    this.schülerservice.getStudents().subscribe(
      (resp) => {
        console.log(resp);
        this.studentDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  deleteStudent(student: any) {
    this.schülerservice.deleteStudent(student.rollNumber).subscribe(
      (resp) => {
        console.log(resp);
        this.getStudentsDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  edit(student: any) {
    this.studentToUpdate = student;
  }

  updateStudent() {
    this.schülerservice.updateStudents(this.studentToUpdate).subscribe(
      (resp) => {
        console.log(resp);
      },
      (err) => {
        console.log(err);
      }
    );
  }

  ngOnInit() {}
}
