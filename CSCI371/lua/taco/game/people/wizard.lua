--[[
mappings are always 0 = myNumber, and 1=1 (person)

people
	0 -> Full name
	1 -> Location
	2 -> Status 
	3 -> Interact function
	4 -> Tick function

]]--
function Wizardinit()
	local myNumber = nextNumber;
	nextNumber = nextNumber + 1;
	
	mapping["Gandalf"] = {[0] = myNumber, [1] = 1};
    mapping["The Wizard"] = {[0] = myNumber, [1] = 1};
    mapping["wizard"] = {[0] = myNumber, [1] = 1};
    mapping["Gandalf the Grey"] = {[0] = myNumber, [1] = 1};
    mapping["Gandalf the white"] = {[0] = myNumber, [1] = 1};
	
    world["wizard"] = {[0] = 0};

	people[myNumber] = {[0] = "Gandalf the Grey", [1] = 19, [2] = 0, [3] = talkWizard, [4] = tickWizard};


end

--[[ Arg is the verb that we tried to use on the person ]]--
function talkWizard(arg, target)
	local mynum = mapping["wizard"][0];
	local myStuff = people[mynum];

	if (arg == 0) then
		print (myStuff[0] .. " looks mysterious at you and chants random puns.\n");
	end

        if (world["wizard"][0] == 0) then
        if ((arg == 10) and (people[mynum][1] == 19)) then
            print("The wizard asks if you have a taco.")
            print("The wizard: Do you have a tasty taco?")

            print("You: ")
            local ans = io.read();

            if (ans == "yes") then
                print("The wizard: Can I have the taco?")

                print("You: ")
                local ans = io.read();

                if (ans == "yes") then
                    local mynum = mapping["taco"][0];
                    local myStuff = items[mynum];
                    arg = 19;
                    target = 2;


                    if ((arg == 19) and (myStuff[1]) == 0) then
                        
                        print ("The wizard: Thank you! That was a tasty taco.");
                        print ("The wizard: Here take this powercell.\n");

                        myStuff[1] = 4;
                        world["wizard"] = {[0] = 1}

                        powercell = powercell + 1;
                        endgame = endgame + 1;

                        -- print ("Endgame: " .. endgame)
                    else
                        print ("The wizard is angry with you as you lied and did not have a taste taco.");
                        print ("The wizard takes a powercell from you.\n");
                        powercell = powercell - 1;
                        banned = banned + 1;
                    end

                else
                    print ("The wizard is angry with you for not giving her a tasty taco.");
                    print ("The wizard takes your taco and a powercell.\n");
                    powercell = powercell - 1;
                    banned = banned + 1;
                end
            elseif (ans == "no") then
                print("Go get a taco and I will give you a powercell.\n")

            end
        else
            if (((arg ~= 10) and (people[mynum][1] ~= 19))) then
                print("You can't talk to Wizard here. You need to go to The Shire to talk to the Wizard.\n")
            end
        end
    else
        print("The wizard: Go bother someone else I am full.\n")
    end
	
end

--[[ Used if this person should do something on their own ]]--
function tickWizard()
	local hmm = math.random(6);

    if (hmm == 2 or hmm == 6) then

        print("The Grey Wizard says: Quit the puns or you will go to the punitentiary.")
        --[[
        local pun = math.random(10);

        if (pun == 1) then
            print("Quit the puns or you will go to the punitentiary.")
        elseif (pun == 2) then
            print("")       
        ]]--
    end
end

