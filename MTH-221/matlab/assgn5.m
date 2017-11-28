% Joshua Wiley
% mth22113

% Problem 1
t = 0:.001:.04;
V =12;
R = 6;
L = .03;
i = (V*(1-exp(-R*t/L)))/R;
plot(i,t);

grid minor;
xlabel('time (sec)');
ylabel('current (A)');

% Problem 2
a = [1 -1 2; 1 3 -6; 0 2 2];
b = [2; 0; 1];
AB= a \ b;

format rat;
disp(AB);

% Problem 3
syms y;

Y = int(y*sqrt(25-y^2), y, 0, 5)/int(y*sqrt(25-y^2), y, 0, 5)