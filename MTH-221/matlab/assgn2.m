% Joshua Wiley
% mth22113

%Problem 1

r = [0.0275 0.03 0.03125 0.03375 0.035 0.0375];
L = 130000;
N = 180;

p = L * (r / 12) .* (1 + (r / 12)).^N ./ ((1+(r/12)).^N - 1);

format bank
disp('          Rate        Monthly Payment');
disp([r', p']);

%Problem 2
x = [5 10 12 17];
y = [8 45 67 120];
plot(x, y, '*');

hold on;

p = polyfit(x, y, 1);
pVal = polyval(p, x);
plot(x, pVal);
disp('Coefficients Linear');
disp([p(1), p(2)]);

p1 = polyfit(x, y, 2);
pVal1 = polyval(p1, x);
plot(x, pVal1);
disp('Coefficients Parabola');
disp([p1(1), p1(2)]);
