//
//  chap01_arrays.c
//  c
//
//  Created by Prat Tanapaisankit on 12/18/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//

#include "chap01_arrays.h"

// 1.6 Arrays

/* count digits, white space, others */
void count() {
    int c, i, nwhite, nother;
    int ndigit[10];
    
    nwhite = nother = 0;
    for (i = 0; i < 10; ++i)
        ndigit[i] = 0;
    
    while ((c = getchar()) != EOF) {
        if (c >= '0' && c <= '9')
            ++ndigit[c-'0'];
        else if (c == ' ' || c == '\n' || c == '\t')
            ++nwhite;
        else
            ++nother;
    }
    printf("digits =");
    for (i = 0; i < 10; ++i)
        printf(" %d", ndigit[i]);
    printf(", white space = %d, other = %d\n", nwhite, nother);
}