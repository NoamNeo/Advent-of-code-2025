#!/bin/bash

input_file="$2"
input_program="$1"
input_data=$(tr ',' ' ' < $input_file)
java $input_program $input_data
#echo $input_data
