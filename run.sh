#!/bin/bash

# Function to start MongoDB
start_mongodb() {

    echo "Starting MongoDB..."

    sudo systemctl start mongod
    MONGODB_PID=$(pgrep mongod)

    if [ $? -eq 0 ]; then
        echo "MongoDB started successfully with PID $MONGODB_PID."
    else
        echo "Failed to start MongoDB."
        exit 1
    fi
}


# Function to start Node-RED
start_nodered() {

    echo "Starting Node-RED..."

    node-red &
    NODERED_PID=$!

    if [ $? -eq 0 ]; then
        echo "Node-RED started successfully with PID $NODERED_PID."
    else
        echo "Failed to start Node-RED."
        exit 1
    fi
}


# Function to start Java Simulator
start_simulator() {

    echo "Starting Java Simulator..."

    java -cp SmartBarracks/target/classes simulator.SimulatorGUI & 
    JAVA_APP_PID=$!

    if [ $? -eq 0 ]; then
        echo "Java Simulator started successfully with PID $JAVA_APP_PID."
    else
        echo "Failed to start Java Simulator."
        exit 1
    fi
}


# Function to handle SIGINT (Ctrl+C)
cleanup() {

    echo "Stopping all services..."

    if [ ! -z "$MONGODB_PID" ]; then
        pkill -TERM -P $MONGODB_PID
        echo "MongoDB stopped."
    fi

    if [ ! -z "$JAVA_APP_PID" ]; then
        pkill -TERM -P $JAVA_APP_PID
        echo "Java Simulator stopped."
    fi

    if [ ! -z "$NODERED_PID" ]; then
        pkill -TERM -P $NODERED_PID
        echo "Node-RED stopped."
    fi

    exit 0
}



# Trap SIGINT (Ctrl+C) to run cleanup
trap cleanup SIGINT

# Starting the services
start_mongodb
start_nodered
start_simulator
echo "All services started successfully."


# Wait indefinitely to keep the script running
while true; do
    sleep 1
done

