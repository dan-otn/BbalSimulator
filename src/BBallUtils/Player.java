package BBallUtils;

import java.util.*;

public class Player {
    private String name;
    private float salaryThisSeason;
    public HashMap<String, Float> stats;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSalaryThisSeason(float salaryThisSeason) {
        this.salaryThisSeason = salaryThisSeason;
    }

    public float getSalaryThisSeason() {
        return this.salaryThisSeason;
    }

    public float statByAttribute(String attribute) {
        return stats.get(attribute);
    }

    public float calcAdvancedStats() {
        float advancedStats = 0f;
        // TODO: iterate map and sum values
        return advancedStats;
    }

    public float predictSalart() {
        // TODO: post vector to ml model
        return 0F;
    }
}
// TODO: class for non NBA player for show inheritance prop