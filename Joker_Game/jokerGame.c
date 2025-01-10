#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool displayGrid(char grid[6][6], char *pos);
void shuffleCharacters(char *chars);
void fillGrid(char grid[6][6], char *chars);
void display(char grid[][6]);
bool validatePositions(char grid[6][6], char *pos1, char *pos2, int *score, int *charsUsed , bool *isRetake);
bool isLastTwoCardsMatched(char grid[6][6]);

int main() {

    printf("\n___________WELCOME TO JOKER GAME__________\n\n");

    char player1[25],player2[25];

    printf("\nEnter Player 1 Name : ");
    scanf("%25s",player1);

    printf("\nEnter Player 2 Name : ");
    scanf("%25s",player2);

    char grid[6][6];

    char chars[36] = {
        'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e',
        'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'J',
        'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o',
        'P', 'p', 'Q', 'q', 'R', 'r'
    };

    shuffleCharacters(chars);
    fillGrid(grid, chars);

    
    int score1 = 0, score2 = 0, charsUsed = 0;
    char pos1[3], pos2[3];
    bool isRetake=0;

    do {

        // Player 1 Turn
        bool flag1 = 0;
        while ((!flag1) || (isRetake)) {
            
            printf("\n\n______%s TURN_____\n\n",player1); 
            bool flag = 0;

            while (!flag) {  
                display(grid);
                printf("\nEnter Position 1 (e.g., A1): ");
                scanf("%2s", pos1);
                printf("\n\n");
                flag = displayGrid(grid, pos1); 
            }
            
            flag = 0;

            while (!flag) {    
                printf("\n\nEnter Position 2 (e.g., A1): ");
                scanf("%2s", pos2);
                printf("\n\n");
                flag = displayGrid(grid, pos2); 
            }

            isRetake=0;
            flag1 = validatePositions(grid, pos1, pos2, &score1, &charsUsed,&isRetake);
            
        }

        // Player 2 Turn
        bool flag2 = 0;
        while ((!flag2) || (isRetake)) {

            
            printf("\n\n_____%s TURN_____\n\n",player2); 
            bool flag = 0;

            while (!flag) {  
                display(grid);
                printf("\n\nEnter Position 1 (e.g., A1): ");
                scanf("%2s", pos1);
                printf("\n\n");
                flag = displayGrid(grid, pos1); 
            }
            
            flag = 0;

            while (!flag) {    
                printf("\n\nEnter Position 2 (e.g., A1): ");
                scanf("%2s", pos2);
                printf("\n\n");
                flag = displayGrid(grid, pos2); 
            }

            isRetake=0;           
            flag2 = validatePositions(grid, pos1, pos2, &score2, &charsUsed,&isRetake);
        }

        if (charsUsed == 34 && (!isLastTwoCardsMatched(grid))) {
            break;
        }
              
    } while (charsUsed <= 36);

    printf("\n\n ********* Game Ended ***********\n\n");

    printf("\n%s Score : %d",player1,score1);
    printf("\n%s Score : %d",player2,score2);

    if (score1 > score2) {
        printf("\n\n%s Wins the Game with Score %d\n",player1, score1);
    } else if (score2 > score1) {
        printf("\n\n%s Wins the Game with Score %d\n",player2, score2);
    } else {
        printf("\nScores are Level\n");
    }
    
    return 0;
}

// Function to display the Grid depending on position
bool displayGrid(char grid[6][6], char *pos) {
    if (!((pos[0] >= 'A' && pos[0] <= 'F') && (pos[1] >= '1' && pos[1] <= '6'))) {
        printf("\nPlease Enter Correct Position (A1 to F6)\n\n");
        return 0;
    }
    if (grid[pos[0] - 'A'][pos[1] - '1'] == '0') {
        printf("\nPosition Already Scored.\n\n");
        return 0;
    }

    printf("\t1\t2\t3\t4\t5\t6\n\n");
    char c = 'A';

    for (int i = 0; i < 6; i++) {
        printf("%c", c);

        for (int j = 0; j < 6; j++) {
            if (pos[0] == c && (pos[1] - '0') == (j + 1)) {
                printf("\t%c", grid[i][j]);
            } else if (grid[i][j] == '0') {
                printf("\t ");
            } else {
                printf("\t#");
            }
        }

        printf("\n\n");
        c++;
    }

    return 1;
}

// Function to display Basic Grid
void display(char grid[][6]) {
    char c = 'A';

    printf("\t1\t2\t3\t4\t5\t6\n\n");

    for (int i = 0; i < 6; i++) {
        printf("%c", c);
        for (int j = 0; j < 6; j++) {
                if (grid[i][j]=='0'){
                    printf("\t ");
                    continue;
                }
                
            printf("\t#");
        }
        printf("\n\n");
        c++;
    }
}

// Function to Shuffle the characters at Random Locations
void shuffleCharacters(char *chars) {
    srand(time(NULL));
    for (int i = 35; i > 0; i--) {
        int j = rand() % (i + 1);
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

// Function to fill the Grid
void fillGrid(char grid[6][6], char *chars) {
    int index = 0;

    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            grid[i][j] = chars[index++];
        }
    }
}

// Function to validate positions and update score
bool validatePositions(char grid[6][6], char *pos1, char *pos2, int *score, int *charsUsed , bool *isRetake) {
    if (strcmp(pos1, pos2) == 0) {
        printf("\nBoth Positions are Same.\n\n");
        return 0;
    }
    
    if ((grid[pos1[0] - 'A'][pos1[1] - '1'] - 32 == grid[pos2[0] - 'A'][pos2[1] - '1']) || 
        (grid[pos2[0] - 'A'][pos2[1] - '1'] - 32 == grid[pos1[0] - 'A'][pos1[1] - '1'])) {

        (*score)++;
        (*charsUsed) += 2;
        grid[pos1[0] - 'A'][pos1[1] - '1'] = '0';
        grid[pos2[0] - 'A'][pos2[1] - '1'] = '0';
        printf("\nCongratulations! Score UPDATED by +1\n\n");
    } else if (grid[pos1[0] - 'A'][pos1[1] - '1'] == 'J' || grid[pos2[0] - 'A'][pos2[1] - '1'] == 'J') {
        (*score) += 2;
        (*charsUsed) += 2;
        grid[pos1[0] - 'A'][pos1[1] - '1'] = '0';
        grid[pos2[0] - 'A'][pos2[1] - '1'] = '0';
        *isRetake=1;
        printf("\nCongratulations! Score UPDATED by +2\n\n");
    } else {
        printf("\nOOPS! Pair Do Not Match. Better Luck Next Time\n\n");
    }
    
    return 1;
}

// Function to check that last two cards in the grid are matched
bool isLastTwoCardsMatched(char grid[6][6]) {
    char ch1, ch2;
    int flag = 1;

    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            if (grid[i][j] != '0' && flag == 1) {
                ch1 = grid[i][j];
                flag++;
            } else if (grid[i][j] != '0' && flag == 2) {
                ch2 = grid[i][j];
                break;
            }
        }
    }
    if (ch1 == ch2) {
        return 1;
    }
    return 0;
}
