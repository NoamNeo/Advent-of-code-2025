#!/bin/bash
input_program="$1"
input_file="$2"
input_data=$(tr '\n' ' ' < $input_file)
java $input_program $input_data
