import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class DataServiceService {
  constructor(private http: HttpClient) {}

  API = "http://localhost:8080";

  public registerStudent(studentData: any) {
    return this.http.post(this.API + "/registerSchüler", studentData);
  }

  public getStudents() {
    return this.http.get(this.API + "/getSchüler");
  }

  public deleteStudent(id: any) {
    return this.http.delete(this.API + "/deleteSchüler?id=" + id);
  }

  public updateStudents(student: any) {
    return this.http.put(this.API + "/updateSchüler", student);
  }

  public getAvailableDevices() {
    return this.http.get(this.API + "/numberWithStatus");
  }
}
