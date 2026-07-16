class Solution {
public:
    string originalDigits(string s) {
        string sol = "";

        // Zero
        while (s.find('z') != string::npos) {
            s.erase(s.find('z'), 1);
            s.erase(s.find('e'), 1);
            s.erase(s.find('r'), 1);
            s.erase(s.find('o'), 1);
            sol += '0';
        }

        // Two
        while (s.find('w') != string::npos) {
            s.erase(s.find('t'), 1);
            s.erase(s.find('o'), 1);
            s.erase(s.find('w'), 1);
            sol += '2';
        }

        // Four
        while (s.find('u') != string::npos) {
            s.erase(s.find('f'), 1);
            s.erase(s.find('o'), 1);
            s.erase(s.find('u'), 1);
            s.erase(s.find('r'), 1);
            sol += '4';
        }

        // Six
        while (s.find('x') != string::npos) {
            s.erase(s.find('s'), 1);
            s.erase(s.find('i'), 1);
            s.erase(s.find('x'), 1);
            sol += '6';
        }

        // Eight
        while (s.find('g') != string::npos) {
            s.erase(s.find('e'), 1);
            s.erase(s.find('g'), 1);
            s.erase(s.find('i'), 1);
            s.erase(s.find('h'), 1);
            s.erase(s.find('t'), 1);
            sol += '8';
        }

        // Five and Seven
        while (s.find('v') != string::npos) {
            s.erase(s.find('v'), 1);

            if (s.find('f') != string::npos) {
                s.erase(s.find('f'), 1);
                s.erase(s.find('i'), 1);
                s.erase(s.find('e'), 1);
                sol += '5';
            } else if (s.find('s') != string::npos) {
                s.erase(s.find('e'), 1);
                s.erase(s.find('e'), 1);
                s.erase(s.find('n'), 1);
                sol += '7';
            }
        }

        // Nine
        while (s.find('i') != string::npos) {
            s.erase(s.find('n'), 1);
            s.erase(s.find('i'), 1);
            s.erase(s.find('n'), 1);
            s.erase(s.find('e'), 1);
            sol += '9';
        }

        // One
        while (s.find('o') != string::npos) {
            s.erase(s.find('o'), 1);
            s.erase(s.find('n'), 1);
            s.erase(s.find('e'), 1);
            sol += '1';
        }

        // Three
        while (s.find('h') != string::npos) {
            s.erase(s.find('t'), 1);
            s.erase(s.find('h'), 1);
            s.erase(s.find('r'), 1);
            s.erase(s.find('e'), 1);
            s.erase(s.find('e'), 1);
            sol += '3';
        }

        sort(sol.begin(), sol.end());
        return sol;
    }
};