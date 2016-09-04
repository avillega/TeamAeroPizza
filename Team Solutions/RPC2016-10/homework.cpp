#include <bits/stdc++.h>
#define _ ios_base::sync_with_stdio(false);cin.tie(NULL);
using namespace std;
typedef long long ll;
typedef long double ld;
int main()
{_

 int n;cin>>n;
 long s;
 ll answ;
 ld a,b;
 while(n--){
    cin>>s;
    answ=-2*s+2;
    ll disc=9-(4*answ);
    a=(-3+sqrt(disc))/2;
    b=(-3-sqrt(disc))/2;

    if(ceil(a)==a && a>=0){
        cout<<(ll)a<<'\n';
    }else if(ceil(b)==b && b>=0){
        cout<<(ll)b<<'\n';
    }else{
        cout<<"No solution"<<'\n';
    }

 }
 return 0;
}
