#include <bits/stdc++.h>
#define _ ios_base::sync_with_stdio(false);cin.tie(NULL);
using namespace std;

int main()
{_

 int n;cin>>n;
 int a, b, c;
 int sum;
 while(n--){
    cin >> a >> b;
    sum=0;
    for(int i=1; i <= (int)(sqrt(a)); i++){
        if(a%i == 0){
            if(a/i == i){
                if(i%b != 0) sum+=i;
            }
            else{
               c = a/i;

               if(c%b != 0) sum+=c;
               if(i%b != 0) sum+=i;
            }
        }

    }
    cout << sum <<"\n";

 }
 return 0;
}
