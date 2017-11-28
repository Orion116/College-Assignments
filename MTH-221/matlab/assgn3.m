% Joshua Wiley
% mth2213

format rat;

A = [1 -2 3 2; 1 2 6 1; -2 0 1 2; 0 3 1 -1];
B = [30; -12; 9; 15];
C = [8 5; 6 1; 2 4; 3 1];
D = [1 -1 3 2 5; 2 -1 -1 1 -3; 5 -4 3 2 -3];

AC = A * C;
%AD = A *D ;
disp(AC);

X = inv(A);
disp(X);

Y = det(A);
disp(Y);

R = rref(D);
disp(R);

Z = inv(A) * B;
disp(Z);