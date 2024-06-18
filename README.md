
# SmartBarracks project
## by Gaudiano Antonio, Muggiasca Luca

This is a project for the Innovative Telecommunication Systems univerity class.
The aim of the work is to make barracks smart in order to automatize and simplify the management of the building,
by means of control sensors automatically according to some rules (specified in the documentation) and remotely.

# Installation

For running the project you will need:
- Java and the latest jdk installed and configured,
- MQTT installed and configured,
- MongoDB installed and configured,
- Node-Red installed and configured, with the following plugins:
    - crypto-wz version 1.0.2,
    - node-red-contrib-email-out version 0.1.1,
    - node-red-contrib-mongodb3 version 2.0.1, 
    - node-red-dashboard version 3.1.5


There is a 'run.sh' script that makes easier starting the project,
simply open a terminal in this directory and type './run.sh' 
and the script will automatically start all the required softwares.

If the script does not work, type in the terminal 'chmod +x run.sh'
which makes the file executable.

Remember to install all the Node-Red required plugins and to import the flows.

# Contents

This directory contains:
- SmartBarracks: all the developed code,
- flows: all the developed flows for Node-Red,
- dbdump: a partial dump of the database (armory access logs),
- run.sh: the autorun script for the project,
- documentation: description of the developed solution and its functionalities.

# Developed solution functionalities

Other than the graphical user interfaces for monitoring the sensors, 
the solution includes various webpage in order to access barrack information remotely:
- sensors' dashboard at 127.0.0.1:1880/ui
- MQTT sensors' registered value at 127.0.0.1:1880/ui
    (choose the page in the top-left corner menu)
- webform to set the sensors remotely at 127.0.0.1:1880/managebarracks
- webpage with all the armory access logs at 127.0.0.1:1880/login
    (default credentials are "admin"-"admin")

For further informations, please refer to the documentation.