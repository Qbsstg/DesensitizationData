package org.example;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.Word;
import cn.hutool.extra.tokenizer.engine.jieba.JiebaEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // 分词器
        JiebaEngine engine = new JiebaEngine();
        Result r = engine.parse("我来到北京清华大学");
        Word next = r.next();
        String s = CollUtil.join((Iterable<Word>) r, " ");

        List<String> list = Arrays.asList("a", "b", "c");


        System.out.println(s);
        System.out.println(replaceRandomElements(list));
    }


    public static String replaceRandomElements(List<String> list) {
        int replaceCount = getReplaceCount(list.size());
        // Random rand = new Random();

        List<Integer> indicesToReplace = IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(indicesToReplace);

        for (int i = 0; i < replaceCount; i++) {
            list.set(indicesToReplace.get(i), "*");
        }

        return String.join(" ", list);
    }

    private static int getReplaceCount(int size) {
        if (size > 10) {
            return 3;
        } else if (size > 5) {
            return 2;
        } else {
            return 1;
        }
    }


}