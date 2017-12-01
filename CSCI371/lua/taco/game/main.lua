

require("parse")
require("superparser");
--require("verbs");
require("support")

require("rooms/roomsetup");

-- Require all people
require("people/dog");
require("people/grandma");
require("people/wizard");
require("people/sensei");
require("people/oracle");

-- Require all things
require("things/taco");
require("things/switch");
require("things/artifact");

-- Require all verbs
require("verbs/talk");
require("verbs/buy");
require("verbs/get");
require("verbs/drop");
require("verbs/inventory");
require("verbs/look");
require("verbs/attack");
require("verbs/give");
require("verbs/use");
require("verbs/eat");



-- Game variables
funds = 10;
lastVerb=nil;
karma = 5;
banned= 0;

-- Initialize tables for hold, people, things, and aliases
mapping = { };
items = { };
people = { };
handlers = {};
verbs = {};
world = {};
nextNumber = 0;
endgame = 0;
powercell = 4;

-- --------------------------------------------------------

-- Call people init functions here
Doginit();
Grandmainit();
Wizardinit();
Senseiinit();
Oracleinit();


-- Call item init functions here
Tacoinit();
Switchinit();
Artifactinit();

-- Call verb init functions here
initAttack();
initBuy();
initDrop();
initEat();
initGet();
initGive();
initInventory();
initLook();
initTalk();
initUse();

-- -------------------------------------------------------------
-- Start main loop
-- 
-- New for Spring 16 - Added a tick to the main loop
--
-- ------------------------------------------------------------
location = 18;
tickCount = 0;
while (true) do
    
    -- print("location: " .. location);

    if (endgame == 4) then
        endGame(0)
    elseif (banned == 4) then
       endGame(1);
    elseif (powercell == -1) then
       endGame(2);
    else
        location = roomMap[location]()
        tickCount = tickCount + 1;
        tick()

    end
end	
