package com.dictionarydb.service.impl;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.springframework.stereotype.Service;

import com.dictionarydb.service.BotService;

import zemberek.tokenization.TurkishSentenceExtractor;
import zemberek.tokenization.TurkishTokenizer;
import zemberek.tokenization.antlr.TurkishLexer;

@Service
public class BotServiceImpl implements BotService {

	@Override
	public List<String> analyzeInput(String input) {
		TurkishSentenceExtractor extractor = TurkishSentenceExtractor.DEFAULT;
		List<String> sentences = extractor.fromParagraph(input);
		for (String sentence : sentences) {
			System.out.println(sentence);
			TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;
			List<Token> tokens = tokenizer.tokenize(sentence);
			for (Token token : tokens) {
			    System.out.println("Content = " + token.getText());
			    System.out.println("Type = " + TurkishLexer.VOCABULARY.getDisplayName(token.getType()));
			    System.out.println("Start = " + token.getStartIndex());
			    System.out.println("Stop  = " + token.getStopIndex());
			    System.out.println();
			}
		}
		
		
		return null;
	}
}
