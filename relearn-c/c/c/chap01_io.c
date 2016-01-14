//
//  chap01_io.c
//  c
//
//  Created by Prat Tanapaisankit on 12/18/15.
//  Copyright © 2015 Prat Tanapaisankit. All rights reserved.
//

#include "chap01_io.h"

/* 
 1.5.1
 copy input to output 
 */
void copy_io_v1() {
    int c;
    c = getchar();
    while (c != EOF) {
        putchar(c);
        c = getchar();
    }
}

void copy_io_v2() {
    int c;
    while ((c = getchar()) != EOF)
        putchar(c);
}

/*
 1.5.2
 charactor counting
 
 ❯❯❯ ehco text >> tmp.txt
 ❯❯❯ gcc -o main c/c/main.c c/c/chap01_io.c
 ❯❯❯ ./main < tmp.txt
 */
long count_chars_v1() {
    long nc = 0;
    while (getchar() != EOF)
        ++nc;
    printf("%ld\n", nc);
    return nc;
}

/* 
 count characters in input; 2nd version
 */
double count_chars_v2() {
    double nc;
    for (nc = 0; getchar() != EOF; ++nc)
        ;
    printf("%.0f\n", nc);
    return nc;
}

/*
 1.5.3 Line Counting

 count lines in input
*/
int count_lines_v1() {
    int c, nl = 0;
    while ((c = getchar()) != EOF) {
        if (c == '\n') {
            ++nl;
        }
        
    }
    printf("%d\n", nl);
    return nl;
}

/*
 Exercise 1-8
 
 count blanks, tabs, newlines
*/
int count_blanks_tabs_newlines() {
    int c = 0, nb = 0, nt = 0, nl = 0;
    while ((c = getchar()) != EOF) {
        if (c == '\n') {
            ++nl;
        } else if (c == '\t') {
            ++nt;
        } else if (c == ' ') {
            ++nb;
        }
    }
    printf("blanks %d, tabs %d, newlines %d\n", nb, nt, nl);
    return nb + nt + nl;
}

/*
 Exercise 1-9
 
 copy input to output, replacing each string of one or more blanks by a single blank
 */
void copy_with_single_blank() {
    char c, previous = 0;
    while ((c = getchar()) != EOF) {
        if (previous == ' ' && c == ' ') {
            continue;
        }
        previous = c;
        putchar(c);
    }
}

/*
 Exercise 1-10
 
 replace tab by \t, backspace by \b, and backslash by \\
 */
void visible_tab_space() {
    char c;
    while ((c = getchar()) != EOF) {
        if (c == '\t')
            printf("\\t");
        else if (c == '\b')
            printf("\\b");
        else if (c == '\\')
            printf("\\\\");
        else
            printf("%c", c);
    }
}

/*
1.5.4 Word Counting
*/
#define IN 1
#define OUT 0
int wc() {
    int c, nl, nw, nc, state;
    state = OUT;
    nl = nw = nc = 0;
    while ((c = getchar()) != EOF) {
        ++nc;
        if (c == '\n')
            ++nl;
        if (c == ' ' || c == '\n' || c == '\t')
            state = OUT;
        else if (state == OUT) {
            state = IN;
            ++nw;
        }
    }
    printf("%d %d %d\n", nl, nw, nc);
    return nw;
}

/*
Exercise 1-12
 prints input one word per line.
*/
void one_word_line() {
    char c;
    int state = OUT;
    while ((c = getchar()) != EOF) {
        if (state == IN && (c == ' ' || c == '\n' || c == '\t')) {
            state = OUT;
            putchar('\n');
        } else if (c == ' ' || c == '\n' || c == '\t') {
            state = OUT;
            continue;
        } else {
            state = IN;
            putchar(c);
        }
    }
}