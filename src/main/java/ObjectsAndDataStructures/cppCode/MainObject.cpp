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
        cout << "Student is working";
    }

    void going() {
        cout << "Student is going somewhere";
    }

    void relaxing() {
        cout << "Student is relaxing";
    }
};