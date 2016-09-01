#include <bits/stdc++.h>
using namespace std;
typedef long double ld;
ld factorial[2520];
ld error = 1e-3;

int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);
    factorial[0] = 0;
	factorial[1] = 0;
    for (int i=2;i<2520; i++){
       factorial[i]=factorial[i-1]+log((ld)i);
    }

    int N;cin>>N;
    int casos=1;
    int a,b,c;
    while(N--){
        cin>>a>>b>>c;
        ld fa=0;ld fb=0;ld fc=0;

        int aux;
        for(int i=0;i<a;i++){
            cin>>aux;
			fa+=factorial[aux];
			//cout<<aux<<" ->"<<factorial[aux]<<'\n';
        }
        for(int i=0;i<b;i++){
            cin>>aux;
            fb+=factorial[aux];
			//cout<<aux<<" ->"<<factorial[aux]<<'\n';
        }
        for(int i=0;i<c;i++){
            cin>>aux;
            fc+=factorial[aux];
			//cout<<aux<<" ->"<<factorial[aux]<<'\n';
        }

        if(fa>fb+error && fa>fc+error){
            cout<<"Case #"<<casos<<": A\n";
        }else if(fb>fa+error && fb>fc+error){
            cout<<"Case #"<<casos<<": B\n";
        }else if(fc>fa+error && fc>fb+error){
            cout<<"Case #"<<casos<<": C\n";
        }else{
            cout<<"Case #"<<casos<<": TIE\n";
        }

        casos++;
        //cout<<fa<<"-"<<fb<<"-"<<fc<<'\n';
    }
    return 0;
}
