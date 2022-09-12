import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';

export interface Userdata {
  id: number;
  name: string;
  vorname: string;
  klasse: string;
}

const ELEMENT_DATA: Userdata[] = [
  {id: 1, name: 'Hendrik', vorname: 'Reuss', klasse: 'ITO2022'},
  {id: 2, name: 'Tarik', vorname: 'Karahan', klasse: 'ITO2022'},
  {id: 3, name: 'Abdulwahab', vorname: 'Alhasan', klasse: 'ITO2022'},
];

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  constructor() {}
  tiles: any;

  ngOnInit() {}
}
