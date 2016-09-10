#include <cstdio>

using namespace std;
int main(){

    int N, mod=10;
    while(scanf("%d\n", &N)){
        mod=10;
        while(N%mod == 0) mod*=10;

        printf("%d\n", N-(mod/10));
    } 
    return 0;
} 