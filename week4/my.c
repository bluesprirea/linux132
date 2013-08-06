#include <stdio.h>

double power(double a, int b) {
	double ret = 1.0;
	int i;
	for (i = 0 ; i < b ; i ++)
		ret *= a;
	return ret;
}

void printBye() {
	printf("Bye\n");
}
void printHello() {
	printf("Hello\n");
}
