
bool checkHours(int minutes)
{
	// variables
	int hours = minutes / 60;
	int month = 0;

	// menu for months
	cout << "\nEnter the Number of the Month\n"
		 << "1.  January   2.  February\n"
		 << "3.  March     4.  April\n"
		 << "5.  May       6.  June\n"
		 << "7.  July      8.  August\n"
		 << "9.  September 10. October\n"
		 << "11. November  12. December\n";
	cout << "\nEnter Month: ";
	cin >> month;

	// clears screen
	system("cls");

	// makes sure the month has the right number of month
	if (month == 2 && hours > 672)
		return false;
	else if ((month == 4 || month == 6 || 
		      month == 9 || month == 11) && hours > 720)
		return false;
	else if ((month == 1 || month == 3 || month == 5 || 
			  month == 7 || month == 8 || 
			  month == 10 || month == 12) && hours > 744)
		return false;
	else
		return true;
}
