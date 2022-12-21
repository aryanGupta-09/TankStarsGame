#include <stdio.h>
#include <errno.h>
#include<pthread.h>
#include<time.h>

void* countA(void* para){

    struct timespec timeBegin, timeEnd;
    long long int hl =  4294967296;
    clock_gettime(CLOCK_MONOTONIC,&timeBegin);

    for(long long int i=0 ; i<hl ; i++){

    }
    clock_gettime(CLOCK_MONOTONIC,&timeEnd);
    double total_time = (double)(timeEnd.tv_sec - timeBegin.tv_sec) + (double)(timeEnd.tv_nsec - timeBegin.tv_nsec)/(1e9);
    printf("%lf\n", total_time);
    return NULL;

}

void* countB(void* para){

    struct timespec timeBegin, timeEnd;
    long long int hl =  4294967296;
    clock_gettime(CLOCK_MONOTONIC,&timeBegin);

    for(long long int i=0 ; i<hl ; i++){

    }
    clock_gettime(CLOCK_MONOTONIC,&timeEnd);
    double total_time = (double)(timeEnd.tv_sec - timeBegin.tv_sec) + (double)(timeEnd.tv_nsec - timeBegin.tv_nsec)/(1e9);
    printf("\n%lf\n", total_time);
    return NULL;

}

void* countC(void* para){

    struct timespec timeBegin, timeEnd;
    long long int hl =  4294967296;
    clock_gettime(CLOCK_MONOTONIC,&timeBegin);

    for(long long int i=0 ; i<hl ; i++){

    }
    clock_gettime(CLOCK_MONOTONIC,&timeEnd);
    double total_time = (double)(timeEnd.tv_sec - timeBegin.tv_sec) + (double)(timeEnd.tv_nsec - timeBegin.tv_nsec)/(1e9);
    printf("\n%lf\n", total_time);
    return NULL;

}

int main(){

    pthread_t thr_A,thr_B,thr_C;
    struct sched_param varA;
    pthread_setschedparam(thr_A,SCHED_OTHER,&varA);
    pthread_create(&thr_A,NULL,countA,NULL);

    pthread_setschedparam(thr_B,SCHED_RR,&varA);
    pthread_create(&thr_B,NULL,countB,NULL);

    pthread_setschedparam(thr_A,SCHED_FIFO,&varA);
    pthread_create(&thr_C,NULL,countC,NULL);

    pthread_exit(NULL);

    return 0;
}

