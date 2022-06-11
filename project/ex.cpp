#include <iostream>

using namespace std;

int main(){

    int n;
    cin >> n;
    char a[n][n];
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    string s;
    cin >> s;
    int x;
    int y;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (a[i][j] == 'P'){
                x = i;
                y = j;
            }
        }
    }

    
    for (int i = 0; i < s.size(); i++){
        if (s[i] == 'L' && a[x][y-1] != '1'){
            if (y-1 >= 0){
                y--;
            } 
        }
        else if (s[i] == 'R' && a[x][y+1] != '1'){
            if(y+1 != n){
                y++;
            }
        }
        else if (s[i] == 'U' && a[x-1][y] != '1'){
            if (x-1 >= 0){
                x--;
            } 
        }
        else if (s[i] == 'D' && a[x+1][y] != '1'){
            if(x+1 != n){
                x++;
            }
        }
    }
    

    cout << "Player final position" << endl;
    cout << "Row: " << x << endl;
    cout << "Col: " << y << endl; 


    return 0;
}