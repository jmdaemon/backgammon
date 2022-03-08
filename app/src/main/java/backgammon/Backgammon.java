package backgammon;

import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class Backgammon {
  public static List<List<Integer>> genDoubles(int[] dice) {
    List<List<Integer>> doubles = new ArrayList<>();
    int die = dice[0];
    // Create:

    // [[6], [6,6], [6,6,6], [6,6,6,6]]
    List<List<Integer>> diceOffsets = new ArrayList<>();
    //for (int i = 0; i < 4; i++) {
      //int offset = dice[i];
      //diceOffsets.add(Arrays.asList(offset));
    //}
    //diceOffsets = Arrays.asList(
    //diceOffsets.stream()
      //.range(0, 4);
    //List<List<Intege>> IntStream
    //diceOffsets = IntStream
      //.range(0,4)
      //.boxed()
      //.map(index -> Arrays.asList(die)) // [[6], [6], [6], [6]]
      //.collect(Collectors.toList());
    //int[][] intDoubles = new int[4][4];
    Integer[][] intDoubles = new Integer[4][4];
    for (int i = 0; i < 4; i++) {
      //for (int j = 0; j < i; j++) {
      for (int j = 0; j <= i; j++) {
        intDoubles[i][j] = die + (die * j);
      }
    }
    System.out.println(intDoubles);

    for (int i = 0; i < 4; i++) {
      List<Integer> offset = Arrays.asList(intDoubles[i]);
      //offset.remove(null);
      //while (offset.remove(null));
      //offset.removeAll(Collections.singleton(null));
      //offset.removeIf(Objects::isNull);
      offset = offset.stream()
        .filter(x -> x != null)
        .collect(Collectors.toList());
      doubles.add(offset);
    }
    return doubles;

    //List<List<Integer>> diceOffset = intDoubles.
      //.SelectMany(T -> T).ToList();
    //for (int i = 0; i < 4; i++) {
      //int[] offset = intDoubles[i];
      //List<Integer> diceOffset = offset.SelectMany(T -> T).ToList();
    //}


    // [6], [6, 6], [6, 6, 6]
    // 1, 2, 3, 4
    // [6] [6] [6] [6]
    // [6] [6, 6] [6, 6, 6] [6, 6, 6]
    //IntStream
      //.range(1, 4)
      //.generate((index) -> { return index; });

    //List<List<Integer>> combined =
      //IntStream
      //.range(1, 4)
      //.mapToObj(i -> row)
      ////.map(i -> die * row)
      //.boxed()
      //.collect(Collectors.toList());
      ////.map(index -> )
      //;

    //List<List<Integer>> combined =
      //IntStream.range();

    //List<Integer> ints = IntStream
      //.range(1, 4)
      //.map(i -> die)
      ////.map(i -> {
        ////IntStream.range
          ////(di)
      ////})
      //.boxed()
      //.collect(Collectors.toList());

    //return Arrays.asList(
        //diceOffsets.stream()
        //.flatMap(diceOffset -> diceOffset.stream())
        //.range(0, 4)
        ////.map(i -> i + die)
        //.collect(Collectors.toList()));

    //return diceOffsets;

    //diceOffsets = Arrays.asList(
        //diceOffsets.stream()
        //.flatMap(diceOffset -> diceOffset.stream())
        //.map(i -> die)
        //.collect(Collectors.toList()));
    //return diceOffsets;
      //.collect(Collectors.toList());
      //.toList()
      //.toList();

    //return diceOffsets.stream()
      //.skip(0) // Skip first element
      //.flatMap(diceOffset -> diceOffset.stream()) // For all offsets in diceOffsets
      //.skip(0) // Skip the first element of all offsets
      //.map(index -> index + die)
      //.map(Collectors.toList())
      //.flatMap(Collection::stream)
      //.collect(Collectors.toList());
      //.toList(diceOffset -> diceOffset.stream().toList());
    //return diceOffsets;
      //.range(1, diceOffset.size())
      //.map ( index -> diceOffset(i));
      //.map( index -> );
      //.flatMap(diceOffset->diceOffset.values().stream())
      //.flatMap(diceOffset->diceOffset.values().stream())
      //.map( (diceOffset) -> {
        //diceOffset.stream().map((offset) -> {

            //}) }
          //)
      //;

    //Iterator<List<Integer>> diceOffsetIter = diceOffsets.iterator();
    //int index = 1;
    //List<Integer> diceOffset = new ArrayList<>();
    //// Ignore the first element: [[6,6], [6,6,6], [6,6,6,6]]
    //for (int i = 1; i < diceOffsets.size(); i++) {
      //diceOffset = diceOffsets.get(i);
      //for (int j = 1; j < diceOffset.size(); ++j) {
        //// Ignore the first element of every array:
        //// [[6], [6,6], [6,6,6]]
        //int offset = diceOffset.get(j);
        //System.out.println(offset);
        //diceOffset.set(j, offset + (die * j));
        ////doubles.set(i, offset + (die * i));
      //}
      //diceOffsets.set(i, diceOffset);
    //}

    //while (diceOffsetIter.hasNext()) {
      //// [6,6,6]
      //List<Integer> diceOffset = diceOffsetIter.next();
      ////int index = 0;
      ////for (Iterator<Integer> offset = diceOffset.iterator(); offset.hasNext(); index++) {
      ////}
      //// Always skip the first element
      //// for x in [6, 6, 6]
      //for (int i = 1; i < diceOffset.size(); i++) {
        //int offset = diceOffset.get(i);
        //System.out.println(offset);
        //diceOffset.set(i, offset + (die * i));
        ////doubles.set(i, offset + (die * i));
      //}
      //diceOffsets.set(index, diceOffset);
    //}


    // [[6], [6,6], [6,6,6], [6,6,6,6]]
    //Iterator<List<Integer>> diceOffsetIter = diceOffsets.iterator();
    //int index = 1;
    //while (diceOffsetIter.hasNext()) {
      //// [6,6,6]
      //List<Integer> diceOffset = diceOffsetIter.next();
      ////int index = 0;
      ////for (Iterator<Integer> offset = diceOffset.iterator(); offset.hasNext(); index++) {
      ////}
      //// Always skip the first element
      //// for x in [6, 6, 6]
      //for (int i = 1; i < diceOffset.size(); i++) {
        //int offset = diceOffset.get(i);
        //System.out.println(offset);
        //diceOffset.set(i, offset + (die * i));
        ////doubles.set(i, offset + (die * i));
      //}
      //diceOffsets.set(index, diceOffset);
    //}


    //diceOffsets.stream().map(offsetIndex -> {});
    // If there is only one element in the set, do not
    //offsets.stream().map((offset) -> point + offset);

    //return doubles;
    //return diceOffsets;

    // [[6], [6,12], [6,12,18], [6,12,18,24]]
    //Iterator<List<Integer>> offsetIter = diceOffsets.iterator();
    //for (int i = 0; i < diceOffsets.size(); i++) {
      //// For all dice offsets
      //for (int j = 0; j < i; j++) {
        //// [6, 12]
        //if (offsetIter.hasNext()) {
          //Iterator<Integer> offset = offsetIter.next().iterator();
          //while (offset.hasNext()) {
            //// 6
            //int offsetValue = offset.next();
          //}
        //}
      //}
    //}
    //Iterator<List<Integer>> offsetIter = diceOffsets.iterator();
    //for (int i = 0; i < 4; i++) {
      //int offset = dice[i];
      //for (int j = 0; j < i; j++) {
        //doubles.add(Arrays.asList(offset + offsetIter.next()));
      //}
    //}

    //List<List<Integer>> diceOffsets = new ArrayList<>();
    //for (int i = 0; i < 4; i++) {
      //int offset = dice[i];
      //diceOffsets.add(Arrays.asList(offset));
    //}
      //List<Integer> _double = new ArrayList<>();
      //_double.add(offset);
      //doubles.add(Arrays.asList(offset));

      // [[6], [6,12], [6,12,18], [6,12,18,24]]
      //Iterator<Integer> _doubleIter = _double.iterator();
      //for (int j = 0; j < i; j++) {
        //_double.add(offset + _doubleIter.next());
        //}
      //}
  }

}
