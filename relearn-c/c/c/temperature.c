//
//  temperature.c
//  c
//
//  Created by Prat Tanapaisankit on 12/17/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//

#include <stdio.h>

// Section 1.4 (Symbolic Constants)
#define LOWER   0
#define UPPER   300
#define STEP    20

/*
 print Fahrenheit-Celsius table
 for fahr = 0, 20, 40, ..., 300
 */
void temperature() {
    float fahr, celsius;
    int lower = 0;
    int upper = 300;
    int step = 20;
    
    // Exercise 1-3
    printf("%3s %6s\n", "Fah", "Cel");
    fahr = lower;
    while (fahr <= upper) {
        celsius = 5.0 * (fahr - 32.0) / 9.0;
        printf("%3.0f %6.1f\n", fahr, celsius);
        fahr += step;
    }
}

// Exercise 1-4 + Section 1.3 (The For Statement)
void cel_fahr_table() {
    printf("%6s %3s\n", "Cel", "Fah");
    for (float fahr = LOWER; fahr <= UPPER; fahr += STEP) {
        printf("%6.1f %3.0f \n", 5.0 * (fahr - 32.0) / 9.0, fahr);
    }
}