#!/bin/bash
input_file="$1"
input_data=$(tr '\n' ' ' <$input_file)
java ../src/Parte2_Decoder.java $input_data 
