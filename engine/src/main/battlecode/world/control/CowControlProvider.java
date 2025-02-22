package battlecode.world.control;

import battlecode.common.*;
import battlecode.server.ErrorReporter;
import battlecode.server.Server;
import battlecode.world.GameWorld;
import battlecode.world.InternalRobot;

import java.util.*;

/**
 * TODO: either have cows increase pollution here, or have something global that increases pollution based on cows
 * in some other file
 */
public class CowControlProvider implements RobotControlProvider {

    /**
     * The directions a cow cares about.
     */
    private final Direction[] DIRECTIONS = {
        Direction.NORTH,
        Direction.NORTHEAST,
        Direction.EAST,
        Direction.SOUTHEAST,
        Direction.SOUTH,
        Direction.SOUTHWEST,
        Direction.WEST,
        Direction.NORTHWEST
    };

    /**
     * The types & order to spawn zombie robots in.
     */
    private final RobotType COW_TYPE = RobotType.COW;

    /**
     * The world we're operating in.
     */
    private GameWorld world;

    /**
     * The queues of zombies to spawn for each den.
     */
    //private final Map<Integer, Map<RobotType, Integer>> denQueues;

    /**
     * An rng based on the world seed.
     */
    private static Random random;

    //private boolean disableSpawning;

    /**
     * Create a CowControlProvider.
     */
    public CowControlProvider() {
        //this.disableSpawning = false;
        //this.denQueues = new HashMap<>();
    }

    /*public CowControlProvider(boolean disableSpawning) {
        this.disableSpawning = disableSpawning;
        //this.denQueues = new HashMap<>();
    }*/

    @Override
    public void matchStarted(GameWorld world) {
        assert this.world == null;

        this.world = world;
        this.random = new Random(world.getMapSeed());
    }

    @Override
    public void matchEnded() {
        assert this.world != null;

        this.world = null;
        this.random = null;
        //this.denQueues.clear();
    }

    @Override
    public void roundStarted() {}

    @Override
    public void roundEnded() {}

    @Override
    public void robotSpawned(InternalRobot robot) {
        // if (robot.getType() == RobotType.ZOMBIEDEN) {
        //     // Create the spawn queue for this robot
        //     final Map<RobotType, Integer> spawnQueue = new HashMap<>();
        //     // Initialize all zombie types in the queue to 0
        //     for (RobotType type : ZOMBIE_TYPES) {
        //         spawnQueue.put(type, 0);
        //     }
        //     // Store it in denQueues
        //     denQueues.put(robot.getID(), spawnQueue);
        // }
    }

    @Override
    public void robotKilled(InternalRobot robot) {}

    @Override
    public void runRobot(InternalRobot robot) {
        if (robot.getType() == COW_TYPE) {
            processCow(robot);
        } else {
            // We're somehow controlling a non-zombie robot.
            // ...
            // just do nothing lol, this will never happen
        }
    }

    /**
     * Run the logic for a zombie den.
     *
     * @param den the zombie den.
     */
   /* private void processZombieDen(InternalRobot den) {
        assert den.getType() == RobotType.ZOMBIEDEN;

        final RobotController rc = den.getController();
        final Map<RobotType, Integer> spawnQueue = denQueues.get(rc.getID());
        final ZombieSpawnSchedule zSchedule = world.getGameMap().getZombieSpawnSchedule(den.getLocation());
        // Update the spawn queue with the values from this round.
        for (ZombieCount count : zSchedule.getScheduleForRound(world.getCurrentRound())) {
            final int currentCount = spawnQueue.get(count.getType());
            spawnQueue.put(count.getType(), currentCount + count.getCount());
        }
        // Spawn as many available robots as possible
        spawnAllPossible(rc, spawnQueue);
        // Now we've tried every direction. If we still have things in queue, damage surrounding robots
        RobotType next = null;
        for (RobotType type : ZOMBIE_TYPES) {
            if (spawnQueue.get(type) != 0) {
                next = type;
            }
        }
        if (next != null) {
            // There are still things in queue, so attack all locations
            for (int dirOffset = 0; dirOffset < DIRECTIONS.length; dirOffset++) {
                final InternalRobot block = world.getObject(rc.getLocation().add(DIRECTIONS[dirOffset]));
                if (block != null && block.getTeam() != Team.ZOMBIE) {
                    block.takeDamage(GameConstants.DEN_SPAWN_PROXIMITY_DAMAGE);
                }
            }

            // Now spawn in remaining locations
            spawnAllPossible(rc, spawnQueue);
        }
    }*/

    /**
     * Spawn as of the queued robots as space allows
     *
     * @param rc a robotcontroller
     * @param spawnQueue the queue of robots to be spawned
     */
    /*private void spawnAllPossible(RobotController rc, Map<RobotType, Integer> spawnQueue) {
        // Walk around the den, attempting to spawn zombies.
        // We choose a random direction to start spawning so that we don't prefer to spawn zombies
        // to the north.
        final int startingDirection = getSpawnDirection(rc.getLocation());
        final int chirality = getSpawnChirality(rc.getLocation());

        for (int dirOffset = 0; dirOffset < DIRECTIONS.length; dirOffset++) {
            final Direction dir = DIRECTIONS[
                    Math.floorMod(startingDirection + dirOffset*chirality, DIRECTIONS.length)
            ];

            // Pull the next zombie type to spawn from the queue
            RobotType next = null;
            for (RobotType type : ZOMBIE_TYPES) {
                if (spawnQueue.get(type) != 0) {
                    next = type;
                }
            }
            if (next == null) {
                break;
            }

            // Check if we can build in this location
            if (rc.canBuild(dir, next)) {
                try {
                    // We can!
                    rc.build(dir, next);
                    spawnQueue.put(next, spawnQueue.get(next) - 1);
                } catch (GameActionException e) {
                    ErrorReporter.report(e, true);
                }
            }
        }
    }*/ //commented stuff out, preserving in case this is helpful for spawning cows

    private void processCow(InternalRobot cow) {
        assert cow.getType() == COW_TYPE;
        final RobotController rc = cow.getController();

        try {
            if (rc.isReady()) {
                int i = 4;
                while (i-->0) { 
                    Direction dir = randomDirection();
                    if (rc.canMove(dir) && !world.isFlooded(rc.adjacentLocation(dir))) {
                        rc.move(dir);
                        break;
                    }
                }
                return;
            }
        } catch (Exception e) {
            ErrorReporter.report(e, true);
        }
    }

    Direction randomDirection() {
        return DIRECTIONS[(int) (random.nextDouble() * (double) DIRECTIONS.length)];
    }

    @Override
    public int getBytecodesUsed(InternalRobot robot) {
        // Cows don't think.
        return 0;
    }

    @Override
    public boolean getTerminated(InternalRobot robot) {
        // Cows never terminate due to computation errors.
        return false;
    }
}