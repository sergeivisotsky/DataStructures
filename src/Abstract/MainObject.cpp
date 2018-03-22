#include <iostream>
using namespace std;
class StudentState {
public:
	virtual void working();
	virtual void going();
	virtual void relaxing();
};

class StudentStateRealization : public StudentState {
public:
	void working() {
		cout << "Student is working too hard doing math!";
	}

	void going() {
		cout << "Student is going to the gym!";
	}

	void relaxing() {
		cout << "Student is watching movie in the cinema!";
	}
};