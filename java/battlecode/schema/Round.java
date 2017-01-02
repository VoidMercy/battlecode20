// automatically generated by the FlatBuffers compiler, do not modify

package battlecode.schema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * A single time-step in a Game.
 * The bulk of the data in the file is stored in tables like this.
 * Note that a struct-of-arrays format is more space efficient than an array-
 * of-structs.
 */
public final class Round extends Table {
  public static Round getRootAsRound(ByteBuffer _bb) { return getRootAsRound(_bb, new Round()); }
  public static Round getRootAsRound(ByteBuffer _bb, Round obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public Round __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  /**
   * The IDs of teams in the Game.
   */
  public int teamIDs(int j) { int o = __offset(4); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int teamIDsLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer teamIDsAsByteBuffer() { return __vector_as_bytebuffer(4, 4); }
  /**
   * The bullet counts of the teams.
   */
  public float teamBullets(int j) { int o = __offset(6); return o != 0 ? bb.getFloat(__vector(o) + j * 4) : 0; }
  public int teamBulletsLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer teamBulletsAsByteBuffer() { return __vector_as_bytebuffer(6, 4); }
  /**
   * The victory points of the teams.
   */
  public int teamVictoryPoints(int j) { int o = __offset(8); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int teamVictoryPointsLength() { int o = __offset(8); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer teamVictoryPointsAsByteBuffer() { return __vector_as_bytebuffer(8, 4); }
  /**
   * The IDs of bodies that moved.
   */
  public int movedIDs(int j) { int o = __offset(10); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int movedIDsLength() { int o = __offset(10); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer movedIDsAsByteBuffer() { return __vector_as_bytebuffer(10, 4); }
  /**
   * The new locations of bodies that have moved. They are defined to be in
   * their new locations at exactly the time round.number*dt.
   */
  public VecTable movedLocs() { return movedLocs(new VecTable()); }
  public VecTable movedLocs(VecTable obj) { int o = __offset(12); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }
  /**
   * New bodies.
   */
  public SpawnedBodyTable spawnedBodies() { return spawnedBodies(new SpawnedBodyTable()); }
  public SpawnedBodyTable spawnedBodies(SpawnedBodyTable obj) { int o = __offset(14); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }
  /**
   * New bullets.
   */
  public SpawnedBulletTable spawnedBullets() { return spawnedBullets(new SpawnedBulletTable()); }
  public SpawnedBulletTable spawnedBullets(SpawnedBulletTable obj) { int o = __offset(16); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }
  /**
   * The IDs of bodies with changed health.
   */
  public int healthChangedIDs(int j) { int o = __offset(18); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int healthChangedIDsLength() { int o = __offset(18); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer healthChangedIDsAsByteBuffer() { return __vector_as_bytebuffer(18, 4); }
  /**
   * The new health levels of bodies with changed health.
   */
  public float healthChangeLevels(int j) { int o = __offset(20); return o != 0 ? bb.getFloat(__vector(o) + j * 4) : 0; }
  public int healthChangeLevelsLength() { int o = __offset(20); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer healthChangeLevelsAsByteBuffer() { return __vector_as_bytebuffer(20, 4); }
  /**
   * The IDs of bodies that died.
   */
  public int diedIDs(int j) { int o = __offset(22); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int diedIDsLength() { int o = __offset(22); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer diedIDsAsByteBuffer() { return __vector_as_bytebuffer(22, 4); }
  /**
   * The IDs of bullets that died.
   */
  public int diedBulletIDs(int j) { int o = __offset(24); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int diedBulletIDsLength() { int o = __offset(24); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer diedBulletIDsAsByteBuffer() { return __vector_as_bytebuffer(24, 4); }
  /**
   * The IDs of robots that performed actions.
   * IDs may repeat.
   */
  public int actionIDs(int j) { int o = __offset(26); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int actionIDsLength() { int o = __offset(26); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer actionIDsAsByteBuffer() { return __vector_as_bytebuffer(26, 4); }
  /**
   * The actions performed.
   */
  public byte actions(int j) { int o = __offset(28); return o != 0 ? bb.get(__vector(o) + j * 1) : 0; }
  public int actionsLength() { int o = __offset(28); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer actionsAsByteBuffer() { return __vector_as_bytebuffer(28, 1); }
  /**
   * The 'targets' of the performed actions. Actions without targets may have
   * any target (typically 0).
   */
  public int actionTargets(int j) { int o = __offset(30); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int actionTargetsLength() { int o = __offset(30); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer actionTargetsAsByteBuffer() { return __vector_as_bytebuffer(30, 4); }
  /**
   * The IDs of bodies that set indicator strings.
   */
  public int indicatorStringIDs(int j) { int o = __offset(32); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int indicatorStringIDsLength() { int o = __offset(32); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer indicatorStringIDsAsByteBuffer() { return __vector_as_bytebuffer(32, 4); }
  /**
   * The indices of the indicator strings that were set.
   */
  public int indicatorStringIndices(int j) { int o = __offset(34); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int indicatorStringIndicesLength() { int o = __offset(34); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer indicatorStringIndicesAsByteBuffer() { return __vector_as_bytebuffer(34, 4); }
  /**
   * The values of the indicator strings that were set.
   */
  public String indicatorStringValues(int j) { int o = __offset(36); return o != 0 ? __string(__vector(o) + j * 4) : null; }
  public int indicatorStringValuesLength() { int o = __offset(36); return o != 0 ? __vector_len(o) : 0; }
  /**
   * The IDs of bodies that set indicator dots
   */
  public int indicatorDotIDs(int j) { int o = __offset(38); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int indicatorDotIDsLength() { int o = __offset(38); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer indicatorDotIDsAsByteBuffer() { return __vector_as_bytebuffer(38, 4); }
  /**
   * The location of the indicator dots
   */
  public VecTable indicatorDotLocs() { return indicatorDotLocs(new VecTable()); }
  public VecTable indicatorDotLocs(VecTable obj) { int o = __offset(40); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }
  /**
   * The RGB values of the indicator dots
   */
  public RGBTable indicatorDotRGBs() { return indicatorDotRGBs(new RGBTable()); }
  public RGBTable indicatorDotRGBs(RGBTable obj) { int o = __offset(42); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }
  /**
   * The IDs of bodies that set indicator lines
   */
  public int indicatorLineIDs(int j) { int o = __offset(44); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int indicatorLineIDsLength() { int o = __offset(44); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer indicatorLineIDsAsByteBuffer() { return __vector_as_bytebuffer(44, 4); }
  /**
   * The start location of the indicator lines
   */
  public VecTable indicatorLineStartLocs() { return indicatorLineStartLocs(new VecTable()); }
  public VecTable indicatorLineStartLocs(VecTable obj) { int o = __offset(46); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }
  /**
   * The end location of the indicator lines
   */
  public VecTable indicatorLineEndLocs() { return indicatorLineEndLocs(new VecTable()); }
  public VecTable indicatorLineEndLocs(VecTable obj) { int o = __offset(48); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }
  /**
   * The RGB values of the indicator lines
   */
  public RGBTable indicatorLineRGBs() { return indicatorLineRGBs(new RGBTable()); }
  public RGBTable indicatorLineRGBs(RGBTable obj) { int o = __offset(50); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }
  /**
   * The first sent Round in a match should have index 1. (The starting state,
   * created by the MatchHeader, can be thought to have index 0.)
   * It should increase by one for each following round.
   */
  public int roundID() { int o = __offset(52); return o != 0 ? bb.getInt(o + bb_pos) : 0; }

  public static int createRound(FlatBufferBuilder builder,
      int teamIDsOffset,
      int teamBulletsOffset,
      int teamVictoryPointsOffset,
      int movedIDsOffset,
      int movedLocsOffset,
      int spawnedBodiesOffset,
      int spawnedBulletsOffset,
      int healthChangedIDsOffset,
      int healthChangeLevelsOffset,
      int diedIDsOffset,
      int diedBulletIDsOffset,
      int actionIDsOffset,
      int actionsOffset,
      int actionTargetsOffset,
      int indicatorStringIDsOffset,
      int indicatorStringIndicesOffset,
      int indicatorStringValuesOffset,
      int indicatorDotIDsOffset,
      int indicatorDotLocsOffset,
      int indicatorDotRGBsOffset,
      int indicatorLineIDsOffset,
      int indicatorLineStartLocsOffset,
      int indicatorLineEndLocsOffset,
      int indicatorLineRGBsOffset,
      int roundID) {
    builder.startObject(25);
    Round.addRoundID(builder, roundID);
    Round.addIndicatorLineRGBs(builder, indicatorLineRGBsOffset);
    Round.addIndicatorLineEndLocs(builder, indicatorLineEndLocsOffset);
    Round.addIndicatorLineStartLocs(builder, indicatorLineStartLocsOffset);
    Round.addIndicatorLineIDs(builder, indicatorLineIDsOffset);
    Round.addIndicatorDotRGBs(builder, indicatorDotRGBsOffset);
    Round.addIndicatorDotLocs(builder, indicatorDotLocsOffset);
    Round.addIndicatorDotIDs(builder, indicatorDotIDsOffset);
    Round.addIndicatorStringValues(builder, indicatorStringValuesOffset);
    Round.addIndicatorStringIndices(builder, indicatorStringIndicesOffset);
    Round.addIndicatorStringIDs(builder, indicatorStringIDsOffset);
    Round.addActionTargets(builder, actionTargetsOffset);
    Round.addActions(builder, actionsOffset);
    Round.addActionIDs(builder, actionIDsOffset);
    Round.addDiedBulletIDs(builder, diedBulletIDsOffset);
    Round.addDiedIDs(builder, diedIDsOffset);
    Round.addHealthChangeLevels(builder, healthChangeLevelsOffset);
    Round.addHealthChangedIDs(builder, healthChangedIDsOffset);
    Round.addSpawnedBullets(builder, spawnedBulletsOffset);
    Round.addSpawnedBodies(builder, spawnedBodiesOffset);
    Round.addMovedLocs(builder, movedLocsOffset);
    Round.addMovedIDs(builder, movedIDsOffset);
    Round.addTeamVictoryPoints(builder, teamVictoryPointsOffset);
    Round.addTeamBullets(builder, teamBulletsOffset);
    Round.addTeamIDs(builder, teamIDsOffset);
    return Round.endRound(builder);
  }

  public static void startRound(FlatBufferBuilder builder) { builder.startObject(25); }
  public static void addTeamIDs(FlatBufferBuilder builder, int teamIDsOffset) { builder.addOffset(0, teamIDsOffset, 0); }
  public static int createTeamIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startTeamIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addTeamBullets(FlatBufferBuilder builder, int teamBulletsOffset) { builder.addOffset(1, teamBulletsOffset, 0); }
  public static int createTeamBulletsVector(FlatBufferBuilder builder, float[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addFloat(data[i]); return builder.endVector(); }
  public static void startTeamBulletsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addTeamVictoryPoints(FlatBufferBuilder builder, int teamVictoryPointsOffset) { builder.addOffset(2, teamVictoryPointsOffset, 0); }
  public static int createTeamVictoryPointsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startTeamVictoryPointsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addMovedIDs(FlatBufferBuilder builder, int movedIDsOffset) { builder.addOffset(3, movedIDsOffset, 0); }
  public static int createMovedIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startMovedIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addMovedLocs(FlatBufferBuilder builder, int movedLocsOffset) { builder.addOffset(4, movedLocsOffset, 0); }
  public static void addSpawnedBodies(FlatBufferBuilder builder, int spawnedBodiesOffset) { builder.addOffset(5, spawnedBodiesOffset, 0); }
  public static void addSpawnedBullets(FlatBufferBuilder builder, int spawnedBulletsOffset) { builder.addOffset(6, spawnedBulletsOffset, 0); }
  public static void addHealthChangedIDs(FlatBufferBuilder builder, int healthChangedIDsOffset) { builder.addOffset(7, healthChangedIDsOffset, 0); }
  public static int createHealthChangedIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startHealthChangedIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addHealthChangeLevels(FlatBufferBuilder builder, int healthChangeLevelsOffset) { builder.addOffset(8, healthChangeLevelsOffset, 0); }
  public static int createHealthChangeLevelsVector(FlatBufferBuilder builder, float[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addFloat(data[i]); return builder.endVector(); }
  public static void startHealthChangeLevelsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addDiedIDs(FlatBufferBuilder builder, int diedIDsOffset) { builder.addOffset(9, diedIDsOffset, 0); }
  public static int createDiedIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startDiedIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addDiedBulletIDs(FlatBufferBuilder builder, int diedBulletIDsOffset) { builder.addOffset(10, diedBulletIDsOffset, 0); }
  public static int createDiedBulletIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startDiedBulletIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addActionIDs(FlatBufferBuilder builder, int actionIDsOffset) { builder.addOffset(11, actionIDsOffset, 0); }
  public static int createActionIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startActionIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addActions(FlatBufferBuilder builder, int actionsOffset) { builder.addOffset(12, actionsOffset, 0); }
  public static int createActionsVector(FlatBufferBuilder builder, byte[] data) { builder.startVector(1, data.length, 1); for (int i = data.length - 1; i >= 0; i--) builder.addByte(data[i]); return builder.endVector(); }
  public static void startActionsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static void addActionTargets(FlatBufferBuilder builder, int actionTargetsOffset) { builder.addOffset(13, actionTargetsOffset, 0); }
  public static int createActionTargetsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startActionTargetsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addIndicatorStringIDs(FlatBufferBuilder builder, int indicatorStringIDsOffset) { builder.addOffset(14, indicatorStringIDsOffset, 0); }
  public static int createIndicatorStringIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startIndicatorStringIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addIndicatorStringIndices(FlatBufferBuilder builder, int indicatorStringIndicesOffset) { builder.addOffset(15, indicatorStringIndicesOffset, 0); }
  public static int createIndicatorStringIndicesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startIndicatorStringIndicesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addIndicatorStringValues(FlatBufferBuilder builder, int indicatorStringValuesOffset) { builder.addOffset(16, indicatorStringValuesOffset, 0); }
  public static int createIndicatorStringValuesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startIndicatorStringValuesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addIndicatorDotIDs(FlatBufferBuilder builder, int indicatorDotIDsOffset) { builder.addOffset(17, indicatorDotIDsOffset, 0); }
  public static int createIndicatorDotIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startIndicatorDotIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addIndicatorDotLocs(FlatBufferBuilder builder, int indicatorDotLocsOffset) { builder.addOffset(18, indicatorDotLocsOffset, 0); }
  public static void addIndicatorDotRGBs(FlatBufferBuilder builder, int indicatorDotRGBsOffset) { builder.addOffset(19, indicatorDotRGBsOffset, 0); }
  public static void addIndicatorLineIDs(FlatBufferBuilder builder, int indicatorLineIDsOffset) { builder.addOffset(20, indicatorLineIDsOffset, 0); }
  public static int createIndicatorLineIDsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startIndicatorLineIDsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addIndicatorLineStartLocs(FlatBufferBuilder builder, int indicatorLineStartLocsOffset) { builder.addOffset(21, indicatorLineStartLocsOffset, 0); }
  public static void addIndicatorLineEndLocs(FlatBufferBuilder builder, int indicatorLineEndLocsOffset) { builder.addOffset(22, indicatorLineEndLocsOffset, 0); }
  public static void addIndicatorLineRGBs(FlatBufferBuilder builder, int indicatorLineRGBsOffset) { builder.addOffset(23, indicatorLineRGBsOffset, 0); }
  public static void addRoundID(FlatBufferBuilder builder, int roundID) { builder.addInt(24, roundID, 0); }
  public static int endRound(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

