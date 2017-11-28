% Joshua WIley
% mth22113

% Problem 1

syms x y h R
factor(8 * x^3 - 27)
factor(6 * x^3 + 25 * x^2 -163*x +168)
factor(30*x^4 - 71*x^3*y - 19*x*y^3 + 12*y^4)

y = sec(sqrt(5*x));
diff(y)
disp('ln');
y = log(x^2 + 5);
diff(y)
y = 3*x * (csc(x^3))^2;
diff(y)

int((x^2 + 4*x +5)*exp(x), x)
int((x^3)/(sqrt(x^2 +9)), x)
int((2*pi * x^3), x, 3, 0)
int((2*pi * x*(h-((h*x)/R))), x, R, 0)

