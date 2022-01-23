package com.company;

public class Main {

    public static String encrypt(String text, int key){

        char[] textChar = new char[text.length()];
        char[] lCh = { 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и','й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э','ю', 'я' };
        char[] upCh = { 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
                'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
                'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я' };

        for (int i=0; i<textChar.length; i++){
            int index = 0;
            boolean isNOTLetter = !Character.isLetter(text.charAt(i));
            if (!isNOTLetter){
                if (Character.isLowerCase(text.charAt(i))){
                    for (int l = 0; l < lCh.length; l++) {
                        if (text.charAt(i) == lCh[l]) index = l;
                    }
                    index += key;
                    if (index > 32){
                        index -= 33;
                    }
                    textChar[i] = lCh[index];
                }else if (Character.isUpperCase(text.charAt(i))){
                    for (int l = 0; l < upCh.length; l++) {
                        if (text.charAt(i) == upCh[l]) index = l;
                    }
                    index += key;
                    if (index > 32){
                        index -= 33;
                    }
                    textChar[i] = upCh[index];
                }
            } else textChar[i] = text.charAt(i);
        }

        return String.copyValueOf(textChar);
    }

    public static void main(String[] args) {
        int shifts = 32;
        String text = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв.\nЗъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх.\nФ юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч.\nЮ зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви.\nГхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню.\nВъгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";
        for (int i = 0; i < shifts; i++) {
            String codeMessage = encrypt(text, i + 1);
            System.out.println((i + 1) + ". " + codeMessage + "\n\n");
        }

    }
}

