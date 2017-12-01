

reqString = "";
mappingString = "roomMap = {\n";

for line in io.lines("data") do
	num,name,north,east,south,west,northwest,northeast,southwest,southeast = string.match(line,"^(.+):(.+):(.+):(.+):(.+):(.+):(.+):(.+):(.+):(.+)$");
	

	print (num .. " *** " .. name);

	file = io.open("../rooms/room"..num..".lua", "w");

	reqString = reqString .. "require(\"../rooms/room"..num.."\");\n";
	mappingString = mappingString .. "\t["..num.."] = room"..num..",\n";
	
	io.output(file);
	io.write("\n");
	io.write("function room"..num.."()\n");
	io.write("\tlocation = "..num.."\n");
	io.write("\tprint (\"-----------------------------------------------------------\")\n");
	io.write("\tprint (\"You are in "..name.."\")\n");
	io.write("\tlist()\n");
	io.write("\tshow(location)\n");
	io.write("\tlocal move = parse()\n");
	io.write("\tif (move == 0) then \n\t\treturn location; \n\tend\n");
	io.write("\n");

	io.write("\t-- North\n");
	if (north == "0") then
		io.write("\tif (move == 1) then\n");
		io.write("\t\tprint(\"You can't move that way!\")\n");
		io.write("\t\treturn location;\n");
		io.write("\tend\n");
	else
		io.write("\tif (move == 1) then \n\t\treturn "..north.."; \n\tend\n");
	end

	io.write("\t-- East\n");
	if (east == "0") then
		io.write("\tif (move == 2) then\n");
		io.write("\t\tprint(\"You can't move that way!\")\n");
		io.write("\t\treturn location;\n");
		io.write("\tend\n");
	else
		io.write("\tif (move == 2) then \n\t\treturn "..east.."; \n\tend\n");
	end

	io.write("\t-- South\n");
	if (south == "0") then
		io.write("\tif (move == 3) then\n");
		io.write("\t\tprint(\"You can't move that way!\")\n");
		io.write("\t\treturn location;\n");
		io.write("\tend\n");
	else
		io.write("\tif (move == 3) then \n\t\treturn "..south.."; \n\tend\n");
	end

	io.write("\t-- West\n");
	if (west == "0") then
		io.write("\tif (move == 4) then\n");
		io.write("\t\tprint(\"You can't move that way!\")\n");
		io.write("\t\treturn location;\n");
		io.write("\tend\n");
	else
		io.write("\tif (move == 4) then \n\t\treturn "..west.."; \n\tend\n");
	end



	io.write("\t-- Northwest\n");
	if (northwest == "0") then
		io.write("\tif (move == 5) then\n");
		io.write("\t\tprint(\"You can't move that way!\")\n");
		io.write("\t\treturn location;\n");
		io.write("\tend\n");
	else
		io.write("\tif (move == 5) then \n\t\treturn "..northwest.."; \n\tend\n");
	end

	io.write("\t-- Northeast\n");
	if (northeast == "0") then
		io.write("\tif (move == 6) then\n");
		io.write("\t\tprint(\"You can't move that way!\")\n");
		io.write("\t\treturn location;\n");
		io.write("\tend\n");
	else
		io.write("\tif (move == 6) then \n\t\treturn "..northeast.."; \n\tend\n");
	end

	io.write("\t-- Southwest\n");
	if (southwest == "0") then
		io.write("\tif (move == 7) then\n");
		io.write("\t\tprint(\"You can't move that way!\")\n");
		io.write("\t\treturn location;\n");
		io.write("\tend\n");
	else
		io.write("\tif (move == 7) then \n\t\treturn "..southwest.."; \n\tend\n");
	end

	io.write("\t-- Southeast\n");
	if (southeast == "0") then
		io.write("\tif (move == 8) then\n");
		io.write("\t\tprint(\"You can't move that way!\")\n");
		io.write("\t\treturn location;\n");
		io.write("\tend\n");
	else
		io.write("\tif (move == 8) then \n\t\treturn "..southeast.."; \n\tend\n");
	end
	io.write("\tprint (\"I don't understand your actions!\")\n");
	io.write("\treturn location\n");

	io.write("\n\n\nend\n");

	io.close(file);

end

mappingString = mappingString .. "\t};";

file = io.open("../rooms/roomsetup.lua", "w");
io.output(file);
io.write("\n");
io.write(reqString);
io.write("\n");
io.write(mappingString);
io.close(file);
