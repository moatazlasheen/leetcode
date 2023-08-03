package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.AnagramGroups;

class AnagramGroupsTest {
	
	
	private AnagramGroups underTest = new AnagramGroups();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String [] input, List<List<String>> expected ) {
		
		List<List<String>> actual = underTest.groupAnagrams(input);
		
		assertEquals(expected, actual);
		
	}
	
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new String []{"eat"}, 
						Arrays.asList(Arrays.asList("eat"))),
			
			Arguments.of(new String []{"eat", "eat"}, 
					Arrays.asList(Arrays.asList("eat", "eat"))),

			Arguments.of(new String []{"eat", "tea"}, 
					Arrays.asList(Arrays.asList("eat", "tea"))),
			
			Arguments.of(new String []{"eat", "tea", "ate"}, 
					Arrays.asList(Arrays.asList("eat", "tea", "ate"))),
			
			Arguments.of(new String []{"eat", "eight", "tea", "ate"}, 
					Arrays.asList(Arrays.asList("eat","tea", "ate"), Arrays.asList("eight"))),
			
			Arguments.of(new String []{"eat","tea","tan","ate","nat","bat"},
					Arrays.asList(Arrays.asList("eat", "tea", "ate"), 
							Arrays.asList("bat"),
							Arrays.asList("tan", "nat") 
							)),
			
			
			Arguments.of(new String []{"ddddddddddg","dgggggggggg"},
					Arrays.asList(Arrays.asList("dgggggggggg"),
							Arrays.asList("ddddddddddg")
							))
			
		);
	}

}
