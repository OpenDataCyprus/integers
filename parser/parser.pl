#!/usr/bin/perl -w
use strict;

use XML::Simple;
use Data::Dumper;
use JSON;

my $xml = new XML::Simple;

my $data = $xml->XMLin("data.xml");

my $jsonString = encode_json($data);

#my $cr_json=`new.jsoni`;
open my $fh, ">", "data.json";
	print $fh $jsonString;
	close $fh;

#print Dumper($jsonString);
