package co.za.ssquared.cruddemo.cucumber.module.employee.core;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class World {

     WorldEmployee worldEmployee;

    Map<Integer,WorldEmployee> worldMap =new HashMap<>();

    public WorldEmployee getWorldEmployee() {
        return worldEmployee;
    }

    public void setWorldEmployee(WorldEmployee worldEmployee) {
        this.worldEmployee = worldEmployee;
    }

    public void addWorldEmployee(Integer Index, WorldEmployee worldEmployee)
    {

        worldMap.putIfAbsent(Index, worldEmployee);
    }

    public Map<Integer, WorldEmployee> getWorldEmployeeMap()
    {
        return Collections.unmodifiableMap(worldMap);
    }



}
