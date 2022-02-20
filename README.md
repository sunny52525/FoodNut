# FoodNut
Work in progreess food search app. find recipes,nutrients info

get api keys from https://www.edamam.com/
***then create keys.c  in  app\src\main\jni and replace keys***

```
#include <jni.h>
JNIEXPORT jstring JNICALL
Java_com_shaun_foodnut_BaseApplication_getRecipeApplicationId(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, *** RECIPE APP ID *** );
}

JNIEXPORT jstring JNICALL
Java_com_shaun_foodnut_BaseApplication_getRecipeApiKey(JNIEnv *env, jobject thiz) {
 return (*env)->  NewStringUTF(env, ***RECIPE API KEY**);
}

JNIEXPORT jstring JNICALL
Java_com_shaun_foodnut_BaseApplication_getNutritionAnalysisApplicationId(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, **NUTRIENT ANALYSIS APP ID**);
}
JNIEXPORT jstring JNICALL
Java_com_shaun_foodnut_BaseApplication_getNutritionAnalysisApiKey(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, **NUTRIENT ANALYSIS API KEY** );
}
JNIEXPORT jstring JNICALL

Java_com_shaun_foodnut_BaseApplication_getFoodApplicationId(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, **FOOD APP ID**);
}
JNIEXPORT jstring JNICALL

Java_com_shaun_foodnut_BaseApplication_getFoodApiKey(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, **FOOD API KEY**);
}



```
