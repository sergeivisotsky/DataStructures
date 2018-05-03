#include "stdafx.h"
#include <string>
#include <list>
#include <iostream>

using namespace std;
struct student_struct {
	string name;
	string surname;
	int age;
	string student_number;
	string group_number;

	student_struct(string _name, string _surname, int _age,
		string _student_number, string _group_number) {
		name = _name;
		surname = _surname;
		age = _age;
		student_number = _student_number;
		group_number = _group_number;
	}
};

int main() {
	list<student_struct> students;
	students.push_front(student_struct("John", "Smith", 23, "171rdb042", "IRDBD13"));
	students.push_front(student_struct("Lilia", "Quick", 19, "171rdb056", "IRDBD10"));
	students.push_front(student_struct("Johanna", "Bloom", 20, "171rdb045", "IRDBD02"));
	for (auto student : students)
	{
		cout << student.name << "\t";
		cout << student.surname << "\t";
		cout << student.age << "\t";
		cout << student.student_number << "\t";
		cout << student.group_number << "\t" << endl;
	}
	return 0;
};